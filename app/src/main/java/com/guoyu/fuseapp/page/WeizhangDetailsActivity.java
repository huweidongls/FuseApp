package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.WeizhangBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeizhangDetailsActivity extends BaseActivity {

    private Context context = WeizhangDetailsActivity.this;

    @BindView(R.id.tv_wfxw)
    TextView tvWfxw;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_time)
    TextView tvTime;

    private WeizhangBean.DataBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weizhang_details);

        bean = (WeizhangBean.DataBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(WeizhangDetailsActivity.this);
        initData();

    }

    private void initData() {

        tvWfxw.setText(bean.getCause());
        tvMoney.setText("罚款"+bean.getManey()+"元");
        tvNumber.setText(bean.getCarNumber());
        tvAddress.setText(bean.getAddress());
        tvTime.setText(bean.getTimeOne().split("\\.")[0]);

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
