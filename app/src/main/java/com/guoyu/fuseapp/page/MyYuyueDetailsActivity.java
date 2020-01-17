package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppBookingBusinessgetOneMesBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyYuyueDetailsActivity extends BaseActivity {

    private Context context = MyYuyueDetailsActivity.this;

    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_dating)
    TextView tvDating;
    @BindView(R.id.tv_bumen)
    TextView tvBumen;
    @BindView(R.id.tv_yewu)
    TextView tvYewu;
    @BindView(R.id.tv_shixiang)
    TextView tvShixiang;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_idcard)
    TextView tvIdcard;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yuyue_details);

        id = getIntent().getStringExtra("id");
        ButterKnife.bind(MyYuyueDetailsActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", id);
        ViseUtil.Get(context, NetUrl.AppBookingBusinessgetOneMes, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppBookingBusinessgetOneMesBean bean = gson.fromJson(s, AppBookingBusinessgetOneMesBean.class);
                tvTime.setText(bean.getData().getBusinessDate());
                tvDating.setText(bean.getData().getHallName());
                tvBumen.setText(bean.getData().getDepName());
                tvYewu.setText(bean.getData().getBusName());
                tvShixiang.setText(bean.getData().getDetailsName());
                tvName.setText(bean.getData().getBusinessUserName());
                tvIdcard.setText(bean.getData().getBusinessUserIdnumber());
                tvPhone.setText(bean.getData().getBusinessUserPhone());
            }
        });

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
