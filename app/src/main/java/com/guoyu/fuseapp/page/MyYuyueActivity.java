package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.MyYuyueAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppBookingBusinessqueryListMesBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyYuyueActivity extends BaseActivity {

    private Context context = MyYuyueActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private MyYuyueAdapter adapter;
    private List<AppBookingBusinessqueryListMesBean.DataBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yuyue);

        ButterKnife.bind(MyYuyueActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("userId", SpUtils.getUserId(context));
        ViseUtil.Get(context, NetUrl.AppBookingBusinessqueryListMes, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppBookingBusinessqueryListMesBean bean = gson.fromJson(s, AppBookingBusinessqueryListMesBean.class);
                mList = bean.getData();
                adapter = new MyYuyueAdapter(mList);
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
