package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.CreditList1Adapter;
import com.guoyu.fuseapp.adapter.CreditList2Adapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.CreditList1Bean;
import com.guoyu.fuseapp.bean.CreditList2Bean;
import com.guoyu.fuseapp.bean.SyscreditBean;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditDetailsActivity extends BaseActivity {

    private Context context = CreditDetailsActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv11)
    TextView tv11;

    private String title = "";
    private SyscreditBean.RowsBean bean;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_details);

        title = getIntent().getStringExtra("title");
        bean = (SyscreditBean.RowsBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(CreditDetailsActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title+"详情");
        tv1.setText(bean.getCOMP_NAME());
        tv2.setText(bean.getUNIFIED_CODE());
        tv3.setText(bean.getREG_NO());
        tv4.setText(bean.getNAT_NAME());
        tv5.setText(bean.getNAT_CERT_CODE());
        tv6.setText(bean.getORG_INST_CODE());
        tv7.setText(bean.getCURRENCY_CAPITAL());
        tv8.setText(bean.getREG_DATE());
        tv9.setText(bean.getCOMP_ADDRESS());
        tv10.setText(bean.getBUSINESS_SCOPE());
        tv11.setText(bean.getCOMP_STATE());

    }

    @OnClick({R.id.rl_back, R.id.btn1, R.id.btn2})
    public void onClick(View view){
        final Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn1:
                dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                String url = "/publicity/data_list.json?configId=_precast_pub_xzxk&conditions=%7B\"unifiedCode\":\"\",\"regCode\":\"\",\"id\":\"\",\"compName\":\""+bean.getCOMP_NAME()+"\"%7D&currentPage="+1+"&pageSize=10";
                ViseHttp.GET(url)
                        .baseUrl("http://www.syscredit.gov.cn/")
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                Logger.e("123123", data);
                                Gson gson = new Gson();
                                CreditList1Bean bean1 = gson.fromJson(data, CreditList1Bean.class);
                                if(bean1.getRows().size() == 0){
                                    ToastUtil.showShort(context, "暂无数据");
                                }else if(bean1.getRows().size() == 1){
                                    intent.setClass(context, CreditDetails1Activity.class);
                                    intent.putExtra("bean", bean1.getRows().get(0));
                                    context.startActivity(intent);
                                }else {
                                    intent.setClass(context, CreditList1Activity.class);
                                    intent.putExtra("name", bean.getCOMP_NAME());
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
                break;
            case R.id.btn2:
                dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                String url1 = "http://www.syscredit.gov.cn/publicity/data_list.json?configId=_precast_pub_xzcf&conditions=%7B\"unifiedCode\":\"\",\"regCode\":\"\",\"id\":\"\",\"compName\":\""+bean.getCOMP_NAME()+"\"%7D&currentPage="+1+"&pageSize=10";
                ViseHttp.GET(url1)
                        .baseUrl("http://www.syscredit.gov.cn/")
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                Logger.e("123123", data);
                                Gson gson = new Gson();
                                CreditList2Bean bean2 = gson.fromJson(data, CreditList2Bean.class);
                                if(bean2.getRows().size() == 0){
                                    ToastUtil.showShort(context, "暂无数据");
                                }else if(bean2.getRows().size() == 1){
                                    intent.setClass(context, CreditDetails2Activity.class);
                                    intent.putExtra("bean", bean2.getRows().get(0));
                                    context.startActivity(intent);
                                }else {
                                    intent.setClass(context, CreditList2Activity.class);
                                    intent.putExtra("name", bean.getCOMP_NAME());
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
                intent.setClass(context, CreditList2Activity.class);
                intent.putExtra("name", bean.getCOMP_NAME());
                startActivity(intent);
                break;
        }
    }

}
