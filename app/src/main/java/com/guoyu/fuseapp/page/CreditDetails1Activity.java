package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.util.Logger;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditDetails1Activity extends BaseActivity {

    private Context context = CreditDetails1Activity.this;

    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_details1);

        name = getIntent().getStringExtra("name");
        ButterKnife.bind(CreditDetails1Activity.this);
        initData();

    }

    private void initData() {

        String url = "/publicity/data_list.json?configId=_precast_pub_xzxk&conditions=%7B\"unifiedCode\":\"\",\"regCode\":\"\",\"id\":\"\",\"compName\":\""+name+"\"%7D&currentPage=1&pageSize=10";
        ViseHttp.GET(url)
                .baseUrl("http://www.syscredit.gov.cn/")
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Logger.e("123123", data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", errMsg);
                    }
                });

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
