package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.SyscreditBean;

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
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn1:
                intent.setClass(context, CreditDetails1Activity.class);
                intent.putExtra("name", bean.getCOMP_NAME());
                startActivity(intent);
                break;
            case R.id.btn2:
                intent.setClass(context, CreditDetails2Activity.class);
                intent.putExtra("name", bean.getCOMP_NAME());
                startActivity(intent);
                break;
        }
    }

}
