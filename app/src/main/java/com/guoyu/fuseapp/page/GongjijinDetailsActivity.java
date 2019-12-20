package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;

import butterknife.ButterKnife;

public class GongjijinDetailsActivity extends BaseActivity {

    private Context context = GongjijinDetailsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongjijin_details);

        ButterKnife.bind(GongjijinDetailsActivity.this);

    }
}
