package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.WeizhangBean;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeizhangActivity extends BaseActivity {

    private Context context = WeizhangActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et)
    EditText et;

    private String title = "";

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weizhang);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(WeizhangActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);

    }

    @OnClick({R.id.rl_back, R.id.btn_search})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_search:

                String s = et.getText().toString();

                if(StringUtils.isEmpty(s)){
                    ToastUtil.showShort(context, "车牌号码不能为空");
                }else {

                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    ViseHttp.GET("/AppBreakRules/getOne")
                            .addParam("number", s)
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    Logger.e("123123", data);
                                    Gson gson = new Gson();
                                    WeizhangBean bean = gson.fromJson(data, WeizhangBean.class);
                                    intent.setClass(context, WeizhangResultActivity.class);
                                    intent.putExtra("title", title);
                                    intent.putExtra("bean", bean);
                                    intent.putExtra("number", s);
                                    startActivity(intent);
                                    WeiboDialogUtils.closeDialog(dialog);
                                }

                                @Override
                                public void onFail(int errCode, String errMsg) {
                                    WeiboDialogUtils.closeDialog(dialog);
                                    ToastUtil.showShort(context, "暂未查到相关信息");
                                }
                            });

                }

                break;
        }
    }

}
