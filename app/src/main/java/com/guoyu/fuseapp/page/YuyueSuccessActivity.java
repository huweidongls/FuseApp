package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuyueSuccessActivity extends BaseActivity {

    private Context context = YuyueSuccessActivity.this;

    @BindView(R.id.tv)
    TextView tv;

    private String nyrTime = "";
    private String time = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_success);

        nyrTime = getIntent().getStringExtra("nyrTime");
        time = getIntent().getStringExtra("time");
        ButterKnife.bind(YuyueSuccessActivity.this);
        initData();

    }

    private void initData() {

        tv.setText("恭喜您预约成功，请于"+nyrTime+" "+time+"，到中心1楼综合导服区，领取预约号码。");

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
