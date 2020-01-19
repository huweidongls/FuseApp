package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.AppCenterAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppCenterqueryListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppCenterActivity extends BaseActivity {

    private Context context = AppCenterActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private AppCenterAdapter adapter;
    private List<AppCenterqueryListBean.DataBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_center);

        ButterKnife.bind(AppCenterActivity.this);
        initData();

    }

    private void initData() {

        ViseUtil.Get(context, NetUrl.AppCenterqueryList, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppCenterqueryListBean bean = gson.fromJson(s, AppCenterqueryListBean.class);
                mList = bean.getData();
                adapter = new AppCenterAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
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
