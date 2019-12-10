package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.app.MyApplication;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/10/9.
 */

public class RegistrationTwoActivity extends BaseActivity {

    private Context context = RegistrationTwoActivity.this;

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_send_code)
    TextView tvGetCode;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String phone = "";
    private Dialog dialog;
    private String type = "";
    private String unionid = "";

    public TextView getCode_btn() {
        return tvGetCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_two);

        unionid = getIntent().getStringExtra("unionid");
        phone = getIntent().getStringExtra("phone");
        type = getIntent().getStringExtra("type");
        MyApplication.registerTimeCount.setActivity(RegistrationTwoActivity.this);
        ButterKnife.bind(RegistrationTwoActivity.this);
        initData();

    }

    private void initData() {

        MyApplication.registerTimeCount.start();
        tv.setText("验证码已发送至手机"+phone);
        if(type.equals("0")){
            tvTitle.setText("注册");
        }else {
            tvTitle.setText("忘记密码");
        }

    }

    @OnClick({R.id.rl_back, R.id.tv_send_code, R.id.btn_commit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_send_code:
                MyApplication.registerTimeCount.start();
                ViseHttp.GET(NetUrl.registerPhone)
                        .addParam("phone", phone)
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                try {
                                    JSONObject jsonObject = new JSONObject(data);
                                    if(jsonObject.optString("status").equals("200")){
                                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                    }else {
                                        ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {

                            }
                        });
                break;
            case R.id.btn_commit:
                String eCode = etCode.getText().toString();
                if(StringUtils.isEmpty(eCode)){
                    ToastUtil.showShort(context, "验证码不能为空");
                }else {
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    ViseHttp.GET(NetUrl.yzmCode)
                            .addParam("phone", phone)
                            .addParam("code", eCode)
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(data);
                                        if (jsonObject.optString("status").equals("200")) {
                                            ToastUtil.showShort(context, jsonObject.optString("errorMsg"));
                                            Intent intent = new Intent();
                                            intent.setClass(context, RegistrationThreeActivity.class);
                                            intent.putExtra("phone", phone);
                                            intent.putExtra("type", type);
                                            intent.putExtra("unionid", unionid);
                                            startActivity(intent);
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
        }
    }

}
