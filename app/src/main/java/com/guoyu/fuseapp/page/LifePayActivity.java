package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifePayActivity extends BaseActivity {

    private Context context = LifePayActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_pay);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(LifePayActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);

    }

    @OnClick({R.id.rl_back, R.id.rl_shui, R.id.rl_dian})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_shui:
                intent.setClass(context, ShuiSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_dian:
                intent.setClass(context, DianSearchActivity.class);
                startActivity(intent);
                break;
        }
    }

}
