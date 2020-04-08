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

public class SocialsecuriTyenuiriesActivity extends BaseActivity {

    private Context context = SocialsecuriTyenuiriesActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_zhanghu)
    TextView tvZhanghu;
    @BindView(R.id.view_zhanghu)
    View viewZhanghu;
    @BindView(R.id.tv_jiaofei)
    TextView tvJiaofei;
    @BindView(R.id.view_jiaofei)
    View viewJiaofei;
    @BindView(R.id.zhanghu)
    LinearLayout zhanghu;
    @BindView(R.id.jiaofei)
    LinearLayout jiaofei;

    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialsecuri_tyenuiries);

        title = getIntent().getStringExtra("title");
        ButterKnife.bind(SocialsecuriTyenuiriesActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);

    }

    @OnClick({R.id.rl_back, R.id.ll_zhanghu, R.id.ll_jiaofei})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_zhanghu:
                tvZhanghu.setTextColor(getResources().getColor(R.color.theme));
                viewZhanghu.setVisibility(View.VISIBLE);
                tvJiaofei.setTextColor(Color.parseColor("#000000"));
                viewJiaofei.setVisibility(View.GONE);
                zhanghu.setVisibility(View.VISIBLE);
                jiaofei.setVisibility(View.GONE);
                break;
            case R.id.ll_jiaofei:
                tvZhanghu.setTextColor(Color.parseColor("#000000"));
                viewZhanghu.setVisibility(View.GONE);
                tvJiaofei.setTextColor(getResources().getColor(R.color.theme));
                viewJiaofei.setVisibility(View.VISIBLE);
                zhanghu.setVisibility(View.GONE);
                jiaofei.setVisibility(View.VISIBLE);
                break;
        }
    }

}
