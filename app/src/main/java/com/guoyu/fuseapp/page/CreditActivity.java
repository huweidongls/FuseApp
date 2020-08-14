package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.CreditListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.SyscreditBean;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditActivity extends BaseActivity {

    private Context context = CreditActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_idcard)
    EditText etIdCard;

    private String title = "";
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(CreditActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);

    }

    @OnClick({R.id.rl_back, R.id.btn_commit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_commit:
                final String idCard = etIdCard.getText().toString();
                if(StringUtils.isEmpty(idCard)){
                    ToastUtil.showShort(context, "企业名称不能为空");
                }else {
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    String url = "/publicity/data_list.json?configId=_precast_pub_code&conditions=%7B\"unifiedCode\":\"\",\"id\":\"\",\"compName\":\""+idCard+"\"%7D&currentPage="+1+"&pageSize=10";
                    ViseHttp.GET(url)
                            .baseUrl("http://www.syscredit.gov.cn/")
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    Logger.e("123123", data);
                                    Gson gson = new Gson();
                                    SyscreditBean bean = gson.fromJson(data, SyscreditBean.class);
                                    if(bean.getRows().size() == 0){
                                        ToastUtil.showShort(context, "暂无数据");
                                    }else if(bean.getRows().size() == 1){
                                        Intent intent = new Intent();
                                        intent.setClass(context, CreditDetailsActivity.class);
                                        intent.putExtra("bean", bean.getRows().get(0));
                                        intent.putExtra("title", title);
                                        startActivity(intent);
                                    }else {
                                        Intent intent = new Intent();
                                        intent.setClass(context, CreditListActivity.class);
                                        intent.putExtra("id", idCard);
                                        intent.putExtra("title", title);
                                        startActivity(intent);
                                    }
                                    WeiboDialogUtils.closeDialog(dialog);
                                }

                                @Override
                                public void onFail(int errCode, String errMsg) {
                                    Logger.e("123123", errMsg);
                                    WeiboDialogUtils.closeDialog(dialog);
                                }
                            });
                }
                break;
        }
    }

}
