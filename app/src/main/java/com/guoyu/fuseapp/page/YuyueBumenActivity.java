package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.DatingYuyueAdapter;
import com.guoyu.fuseapp.adapter.YuyueBumenAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppAppointmentqueryListBean;
import com.guoyu.fuseapp.bean.AppointmentNoticeAppqueryListlimint5Bean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.widget.ScrollTextView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuyueBumenActivity extends BaseActivity {

    private Context context = YuyueBumenActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.tv_gg)
    ScrollTextView tvGg;
    @BindView(R.id.ll_gg)
    LinearLayout llGg;
    @BindView(R.id.view)
    View view;

    private YuyueBumenAdapter adapter;
    private List<AppAppointmentqueryListBean.DataBean> mList;

//    private String id = "";
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyue_bumen);

//        id = getIntent().getStringExtra("id");
        ButterKnife.bind(YuyueBumenActivity.this);
        init();
        initGg();

    }

    private void init() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        map.put("pid", "0");
        ViseUtil.Get(context, NetUrl.AppAppointmentqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppAppointmentqueryListBean bean = gson.fromJson(s, AppAppointmentqueryListBean.class);
                if(bean.getData().size()>0){
                    initData(bean.getData().get(0).getId()+"");
                }
            }
        });

    }

    private void initGg() {

        ViseUtil.Get(context, NetUrl.AppointmentNoticeAppqueryListlimint5, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppointmentNoticeAppqueryListlimint5Bean bean = gson.fromJson(s, AppointmentNoticeAppqueryListlimint5Bean.class);
                if(bean.getData().size()>0){
                    llGg.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                    List<String> list = new ArrayList<>();
                    for (AppointmentNoticeAppqueryListlimint5Bean.DataBean bean1 : bean.getData()){
                        list.add(bean1.getTitle());
                    }
                    tvGg.setList(list);
                    tvGg.startScroll();
                    tvGg.setOnSelectListener(new ScrollTextView.OnSelectListener() {
                        @Override
                        public void onItemClick(int pos) {
                            Intent intent = new Intent();
                            intent.setClass(context, YuyueGgActivity.class);
                            startActivity(intent);
                        }
                    });
                }else {
                    llGg.setVisibility(View.GONE);
                    view.setVisibility(View.GONE);
                }
            }
        });

    }

    private void initData(String id) {

        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pid", id);
                map.put("pageSize", "10");
                map.put("pageNum", "1");
                ViseUtil.Get(context, NetUrl.AppAppointmentqueryList, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppAppointmentqueryListBean bean = gson.fromJson(s, AppAppointmentqueryListBean.class);
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
                map.put("pid", id);
                map.put("pageSize", "10");
                map.put("pageNum", page+"");
                ViseUtil.Get(context, NetUrl.AppAppointmentqueryList, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppAppointmentqueryListBean bean = gson.fromJson(s, AppAppointmentqueryListBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page+1;
                    }
                });
            }
        });

        Map<String, String> map = new LinkedHashMap<>();
        map.put("pid", id);
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        ViseUtil.Get(context, NetUrl.AppAppointmentqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppAppointmentqueryListBean bean = gson.fromJson(s, AppAppointmentqueryListBean.class);
                mList = bean.getData();
                adapter = new YuyueBumenAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                page = 2;
            }
        });

    }

    @OnClick(R.id.rl_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
