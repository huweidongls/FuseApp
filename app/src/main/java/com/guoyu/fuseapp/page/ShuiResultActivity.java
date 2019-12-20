package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuiResultActivity extends BaseActivity {

    private Context context = ShuiResultActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shui_result);

        ButterKnife.bind(ShuiResultActivity.this);

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
