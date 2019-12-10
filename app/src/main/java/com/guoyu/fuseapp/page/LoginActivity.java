package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.LoginBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.guoyu.fuseapp.wxapi.WXShare;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/10/9.
 */

public class LoginActivity extends BaseActivity {

    private Context context = LoginActivity.this;

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    private boolean isShowPwd = false;

    private Dialog dialog;

    private WXShare wxShare;
    private IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        api = WXAPIFactory.createWXAPI(context, null);
        api.registerApp(WXShare.APP_ID);
        ButterKnife.bind(LoginActivity.this);

    }

    @OnClick({R.id.rl_back, R.id.rl, R.id.btn, R.id.tv_register, R.id.tv_forgot, R.id.tv_wx})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl:
                if (isShowPwd) {
                    isShowPwd = false;
                    Glide.with(context).load(R.mipmap.icon0063x).into(iv);
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPwd.setSelection(etPwd.getText().length());
                } else {
                    isShowPwd = true;
                    Glide.with(context).load(R.mipmap.login_icon033x).into(iv);
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPwd.setSelection(etPwd.getText().length());
                }
                break;
            case R.id.btn:
                String name = etName.getText().toString();
                String pwd = etPwd.getText().toString();
                if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)) {
                    ToastUtil.showShort(context, "账号或密码不能为空");
                } else {
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    ViseHttp.GET(NetUrl.loginApp)
                            .addParam("phone", name)
                            .addParam("psd", pwd)
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    Logger.e("123123", data);
                                    try {
                                        JSONObject jsonObject = new JSONObject(data);
                                        if (jsonObject.optString("status").equals("200")) {
                                            ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                            Gson gson = new Gson();
                                            LoginBean bean = gson.fromJson(data, LoginBean.class);
                                            SpUtils.setToken(context, bean.getAppToken());
                                            SpUtils.setUserId(context, bean.getData().getId() + "");
                                            SpUtils.setPhoneNum(context, bean.getData().getPhone());
                                            Map<String, String> map = new LinkedHashMap<>();
                                            map.put("jnkjToken", bean.getAppToken());
                                            ViseHttp.CONFIG().baseUrl(NetUrl.BASE_URL)
                                                    .globalHeaders(map);
                                            finish();
                                        } else {
                                            ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
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
                break;
            case R.id.tv_register:
                intent.setClass(context, RegisterActivity.class);
                intent.putExtra("type", "0");
                startActivity(intent);
                finish();
                break;
            case R.id.tv_forgot:
                intent.setClass(context, RegisterActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                finish();
                break;
            case R.id.tv_wx:
                if (!api.isWXAppInstalled()) {
                    ToastUtil.showShort(context, "您的设备未安装微信客户端");
                } else {
                    final SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test";
                    api.sendReq(req);
                    finish();
                }
                break;
        }
    }
}
