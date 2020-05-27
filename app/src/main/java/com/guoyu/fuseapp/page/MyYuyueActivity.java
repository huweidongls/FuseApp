package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.MyYuyueAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppAppointmentgetByAppointmentAppBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;

    private MyYuyueAdapter adapter;
    private List<AppAppointmentgetByAppointmentAppBean.DataBean> mList;

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_yuyue);

        ButterKnife.bind(MyYuyueActivity.this);
        initData();

    }

    private void initData() {

        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("id", SpUtils.getUserId(context));
                map.put("pageSize", "10");
                map.put("pageNum", "1");
                ViseUtil.Get(context, NetUrl.AppAppointmentgetByAppointmentApp, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppAppointmentgetByAppointmentAppBean bean = gson.fromJson(s, AppAppointmentgetByAppointmentAppBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("id", SpUtils.getUserId(context));
                map.put("pageSize", "10");
                map.put("pageNum", page+"");
                ViseUtil.Get(context, NetUrl.AppAppointmentgetByAppointmentApp, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppAppointmentgetByAppointmentAppBean bean = gson.fromJson(s, AppAppointmentgetByAppointmentAppBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page+1;
                    }
                });
            }
        });

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", SpUtils.getUserId(context));
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        ViseUtil.Get(context, NetUrl.AppAppointmentgetByAppointmentApp, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppAppointmentgetByAppointmentAppBean bean = gson.fromJson(s, AppAppointmentgetByAppointmentAppBean.class);
                mList = bean.getData();
                adapter = new MyYuyueAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                page = 2;
            }
        });
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("userId", SpUtils.getUserId(context));
//        ViseUtil.Get(context, NetUrl.AppBookingBusinessqueryListMes, map, new ViseUtil.ViseListener() {
//            @Override
//            public void onReturn(String s) {
//                Gson gson = new Gson();
//                AppBookingBusinessqueryListMesBean bean = gson.fromJson(s, AppBookingBusinessqueryListMesBean.class);
//                mList = bean.getData();
//                adapter = new MyYuyueAdapter(mList);
//                LinearLayoutManager manager = new LinearLayoutManager(context);
//                manager.setOrientation(LinearLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(manager);
//                recyclerView.setAdapter(adapter);
//            }
//        });

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
