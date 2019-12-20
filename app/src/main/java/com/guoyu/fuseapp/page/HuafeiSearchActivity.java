package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HuafeiSearchActivity extends BaseActivity {

    private Context context = HuafeiSearchActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huafei_search);

        ButterKnife.bind(HuafeiSearchActivity.this);

    }

    @OnClick({R.id.rl_back, R.id.btn_search})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_search:
                intent.setClass(context, HuafeiResultActivity.class);
                startActivity(intent);
                break;
        }
    }

}
