package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.CommunityBulletinAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.CommunitServiceListBean;
import com.guoyu.fuseapp.bean.CommunitServiceNewsBean;
import com.guoyu.fuseapp.bean.CommunityServiceFenleiBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ViseUtil;
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

public class CommunityServiceActivity extends BaseActivity {

    private Context context = CommunityServiceActivity.this;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.refreshs)
    SmartRefreshLayout refreshs;
    @BindView(R.id.spinner1)
    Spinner spinnertext;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.rr_list)
    RelativeLayout rr_list;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private int sid = 0;
    private int tid = 0;
    private String title = "";
    private int page = 1;
    private String funCode = "";
    private CommunityBulletinAdapter adapter;
    private List<CommunitServiceNewsBean.DataBean> mList;
    private List<String> list = new ArrayList<String>();
    private List<String> list2 = new ArrayList<String>();
    private List<CommunityServiceFenleiBean.DataBean> fList;
    private List<CommunitServiceListBean.DataBean> TList;
    private ArrayAdapter<String> adapters;
    private ArrayAdapter<String> adapter4;

    private String areaId = "";
    private String typeId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_service);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        areaId = SpUtils.getShequId(context);
        ButterKnife.bind(CommunityServiceActivity.this);
        initData();
        init_shequ();
        init_fenlei();
        spinnertext.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sInfo = parent.getItemAtPosition(position).toString();
                if (sInfo == "全部") {
                    areaId = "";
                    search();
                } else {
                    areaId = TList.get(position - 1).getId()+"";
                    search();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sInfo = parent.getItemAtPosition(position).toString();
                if (sInfo == "全部") {
                    typeId = "";
                    search();
                } else {
                    typeId = fList.get(position - 1).getId()+"";
                    //Log.e("idididididiid",position+"");
                    search();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initData() {
        tvTitle.setText(title);
        refreshs.setRefreshHeader(new MaterialHeader(CommunityServiceActivity.this
        ));
        refreshs.setRefreshFooter(new ClassicsFooter(CommunityServiceActivity.this));
        refreshs.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                if(!StringUtils.isEmpty(areaId)){
                    map.put("areaId", areaId);
                }
                if(!StringUtils.isEmpty(typeId)){
                    map.put("typeId", typeId);
                }
                ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        CommunitServiceNewsBean beanf = gson.fromJson(s, CommunitServiceNewsBean.class);
                        mList.clear();
                        mList.addAll(beanf.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                    }
                });
                refreshLayout.finishRefresh(1000);
            }
        });
        refreshs.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", page + "");
                map.put("pageSize", "10");
                if(!StringUtils.isEmpty(areaId)){
                    map.put("areaId", areaId);
                }
                if(!StringUtils.isEmpty(typeId)){
                    map.put("typeId", typeId);
                }
                ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        CommunitServiceNewsBean beanf = gson.fromJson(s, CommunitServiceNewsBean.class);
                        mList.addAll(beanf.getData());
                        adapter.notifyDataSetChanged();
                        page = page + 1;
                    }
                });
                refreshLayout.finishLoadMore(1000);
            }
        });
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        if(!StringUtils.isEmpty(areaId)){
            map.put("areaId", areaId);
        }
        if(!StringUtils.isEmpty(typeId)){
            map.put("typeId", typeId);
        }
        ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gsons = new Gson();
                CommunitServiceNewsBean beanf = gsons.fromJson(s, CommunitServiceNewsBean.class);
                mList = beanf.getData();
                adapter = new CommunityBulletinAdapter(mList, title, funCode);
                LinearLayoutManager manager = new LinearLayoutManager(CommunityServiceActivity.this);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler_view.setLayoutManager(manager);
                recycler_view.setAdapter(adapter);
                page = 2;
                if (mList.size() > 0) {
                    empty_order_bloacks.setVisibility(View.GONE);
                    refreshs.setVisibility(View.VISIBLE);
                } else {//empty_order_bloacks
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    refreshs.setVisibility(View.GONE);
                }

            }
        });
    }

    private void search() {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("pageSize", "10");
            map.put("pageNum", "1");
            if(!StringUtils.isEmpty(areaId)){
                map.put("areaId", areaId);
            }
            if(!StringUtils.isEmpty(typeId)){
                map.put("typeId", typeId);
            }
            ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfoqueryList, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    Gson gsons = new Gson();
                    CommunitServiceNewsBean beanf = gsons.fromJson(s, CommunitServiceNewsBean.class);
                    mList = beanf.getData();
                    adapter = new CommunityBulletinAdapter(mList, title, funCode);
                    LinearLayoutManager manager = new LinearLayoutManager(CommunityServiceActivity.this);
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(manager);
                    recycler_view.setAdapter(adapter);
                    page = 2;
                    if (mList.size() > 0) {
                        empty_order_bloacks.setVisibility(View.GONE);
                        refreshs.setVisibility(View.VISIBLE);
                    } else {//empty_order_bloacks
                        empty_order_bloacks.setVisibility(View.VISIBLE);
                        refreshs.setVisibility(View.GONE);
                    }

                }
            });
    }

    private void init_fenlei() {
        ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfofindType, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Log.e("fffffffff", s);
                Gson gson = new Gson();
                CommunityServiceFenleiBean bean = gson.fromJson(s, CommunityServiceFenleiBean.class);
                fList = bean.getData();
                //fList.add(0,"全部");
                //fList.add("全部");
                list2.add("全部");
                for (CommunityServiceFenleiBean.DataBean bean2 : bean.getData()) {
                    list2.add(bean2.getSubName());
                }
                adapter4 = new ArrayAdapter<String>(CommunityServiceActivity.this, android.R.layout.simple_spinner_item, list2);
                //第三步：设置下拉列表下拉时的菜单样式
                adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //第四步：将适配器添加到下拉列表上
                spinner2.setAdapter(adapter4);
            }
        });
    }

    private void init_shequ() {
        ViseUtil.Get(CommunityServiceActivity.this, NetUrl.AppCommunityServiceInfofindCommunity, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                CommunitServiceListBean bean = gson.fromJson(s, CommunitServiceListBean.class);
                TList = bean.getData();
                list.add("全部");
                for (CommunitServiceListBean.DataBean bean1 : bean.getData()) {
                    list.add(bean1.getPcommName());
                }
                adapters = new ArrayAdapter<String>(CommunityServiceActivity.this, android.R.layout.simple_spinner_item, list);
                //第三步：设置下拉列表下拉时的菜单样式
                adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //第四步：将适配器添加到下拉列表上
                spinnertext.setAdapter(adapters);
                for (int i = 0; i<TList.size(); i++){
                    if(!StringUtils.isEmpty(areaId)&&TList.get(i).getId() == Integer.valueOf(areaId)){
                        spinnertext.setSelection(i+1);
                    }
                }
            }
        });
    }

    @OnClick({R.id.rl_back})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }
}
