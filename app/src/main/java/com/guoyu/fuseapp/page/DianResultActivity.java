package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DianResultActivity extends BaseActivity {

    private Context context = DianResultActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_result);

        ButterKnife.bind(DianResultActivity.this);

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
