package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SocialseCurityActivity extends BaseActivity {

    private Context context = SocialseCurityActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialse_curity);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(SocialseCurityActivity.this);
        initData();

    }

    private void initData(){

        tvTitle.setText(title);
        
    }

    @OnClick({R.id.rl_back, R.id.btn_commit})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_commit:
                intent.setClass(context, SocialsecuriTyenuiriesActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
                break;
        }
    }

}
