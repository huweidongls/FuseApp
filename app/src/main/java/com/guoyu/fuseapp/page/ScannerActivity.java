package com.guoyu.fuseapp.page;

import android.os.Bundle;
import android.view.View;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.king.zxing.CaptureActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScannerActivity extends CaptureActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scanner);

        ButterKnife.bind(ScannerActivity.this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scanner;
    }

//    @Override
//    public int getIvTorchId() {
//        return 0;
//    }

    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
