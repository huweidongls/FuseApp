package com.guoyu.fuseapp.wxapi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.guoyu.fuseapp.bean.UnionidBean;
import com.guoyu.fuseapp.dialog.DialogWxType;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.RegisterActivity;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/9.
 */

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private Context context = WXEntryActivity.this;

    private IWXAPI api;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //接收到分享以及登录的intent传递handleIntent方法，处理结果
        api = WXAPIFactory.createWXAPI(this, WXShare.APP_ID, false);
        api.handleIntent(getIntent(), this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

//        Logger.i("onNewIntent");
        setIntent(intent);
        if (!api.handleIntent(intent, this)) {
            finish();
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {
    }

    @Override
    public void onResp(BaseResp baseResp) {
        //登录回调
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) baseResp).code;
                //获取accesstoken
                getAccessToken(code);
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                ToastUtil.showShort(context, "用户拒绝授权");
                finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                ToastUtil.showShort(context, "用户取消");
                finish();
                break;
            default:
                finish();
                break;
        }
    }

    private void getAccessToken(String code) {

        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("code", code);
        ViseHttp.GET("AppWeChat/weChatLogin")
                .addParams(map)
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            final JSONObject jsonObject = new JSONObject(data);
                            if(jsonObject.optString("status").equals("200")){
                                Gson gson = new Gson();
                                UnionidBean bean = gson.fromJson(data, UnionidBean.class);
                                SpUtils.setToken(context, bean.getData().getAppToken());
                                SpUtils.setUserId(context, bean.getData().getData().getId() + "");
                                SpUtils.setPhoneNum(context, bean.getData().getData().getPhone());
                                Map<String, String> map = new LinkedHashMap<>();
                                map.put("jnkjToken", bean.getData().getAppToken());
                                ViseHttp.CONFIG().baseUrl(NetUrl.BASE_URL)
                                        .globalHeaders(map);
                                finish();
                            }
                            else if(jsonObject.optString("status").equals("666")){
                                DialogWxType dialogWxType = new DialogWxType(context, new DialogWxType.ClickListener() {
                                    @Override
                                    public void onRegister() {
                                        Intent intent = new Intent();
                                        intent.setClass(context, RegisterActivity.class);
                                        intent.putExtra("type", "0");
                                        intent.putExtra("unionid", jsonObject.optString("data"));
                                        startActivity(intent);
                                        WXEntryActivity.this.finish();
                                    }

                                    @Override
                                    public void onLogin() {
                                        Intent intent = new Intent();
                                        intent.setClass(context, LoginActivity.class);
                                        intent.putExtra("unionid", jsonObject.optString("data"));
                                        startActivity(intent);
                                        WXEntryActivity.this.finish();
                                    }
                                });
                                dialogWxType.setCancelable(false);
                                dialogWxType.setCanceledOnTouchOutside(false);
                                dialogWxType.show();
                            }else {
                                ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                finish();
                            }
                            WeiboDialogUtils.closeDialog(dialog);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        WeiboDialogUtils.closeDialog(dialog);
                    }
                });

    }

}