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

public class SocialsecuriTyenuiriesActivity extends BaseActivity {

    private Context context = SocialsecuriTyenuiriesActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;

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

    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
