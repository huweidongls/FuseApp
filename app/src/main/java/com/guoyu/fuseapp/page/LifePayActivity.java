package com.guoyu.fuseapp.page;

import android.content.Context;
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
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;

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

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl1:
                tv1.setTextColor(Color.parseColor("#D62424"));
                tv2.setTextColor(Color.parseColor("#000000"));
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.GONE);
                break;
            case R.id.rl2:
                tv1.setTextColor(Color.parseColor("#000000"));
                tv2.setTextColor(Color.parseColor("#D62424"));
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.VISIBLE);
                break;
        }
    }

}
