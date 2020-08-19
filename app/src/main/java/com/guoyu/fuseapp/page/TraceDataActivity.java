package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.TraceDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TraceDataActivity extends BaseActivity {

    private Context context = TraceDataActivity.this;

    @BindView(R.id.tv_qiye_name)
    TextView tvQiyeName;
    @BindView(R.id.tv_qiye_lxr)
    TextView tvQiyeLxr;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_chanpin_name)
    TextView tvChanpinName;
    @BindView(R.id.tv_shengchan_riqi)
    TextView tvShengchanRiqi;
    @BindView(R.id.tv_youxiaoqi)
    TextView tvYouxiaoqi;
    @BindView(R.id.tv_leibie_name)
    TextView tvLeibieName;
    @BindView(R.id.tv_cp_name)
    TextView tvCpName;
    @BindView(R.id.tv_pinzhong_details)
    TextView tvPinzhongDetails;
    @BindView(R.id.tv_fr)
    TextView tvFr;
    @BindView(R.id.tv_fzjg)
    TextView tvFzjg;
    @BindView(R.id.tv_jgdw)
    TextView tvJgdw;

    private TraceDataBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace_data);

        bean = (TraceDataBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(TraceDataActivity.this);
        initData();

    }

    private void initData() {

        if(bean.getEnterpriseVO()!=null){
            tvQiyeName.setText(bean.getEnterpriseVO().getEnt_name());
            tvQiyeLxr.setText(bean.getEnterpriseVO().getLinkman());
            tvPhone.setText(bean.getEnterpriseVO().getPhone());
        }
        if(bean.getProductBatchVO()!=null){
            tvChanpinName.setText(bean.getProductBatchVO().getProduct_name());
            tvShengchanRiqi.setText(bean.getProductBatchVO().getProduct_date_str());
            tvYouxiaoqi.setText(bean.getProductBatchVO().getProduct_valid_str());
        }
        if(bean.getProductVO()!=null){
            tvLeibieName.setText(bean.getProductVO().getLbmc());
            tvCpName.setText(bean.getProductVO().getProduct_name());
            tvPinzhongDetails.setText(bean.getProductVO().getPzmx());
        }
        if(bean.getProductionLicenseVO()!=null){
            tvFr.setText(bean.getProductionLicenseVO().getFddbr());
            tvFzjg.setText(bean.getProductionLicenseVO().getFzjg());
            tvJgdw.setText(bean.getProductionLicenseVO().getJgdw());
        }

    }

    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
