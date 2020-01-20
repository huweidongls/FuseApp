package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.PolicyInteractionAdapter;
import com.guoyu.fuseapp.bean.PolicyInteractionBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
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

public class PolicyInteractionActivity extends AppCompatActivity {

    private Context context = PolicyInteractionActivity.this;
    @BindView(R.id.rv)
    RecyclerView recyclerView1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;
    private int page = 1;
    private int page2 = 1;
    private int page3 = 1;
    private String typeId = "";
    private PolicyInteractionAdapter adapter;
    private PolicyInteractionAdapter adapter2;
    private PolicyInteractionAdapter adapter3;
    private List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> mList;
    private List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> mList2;
    private List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> mList3;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_interaction);
        ButterKnife.bind(PolicyInteractionActivity.this);
        initData(1);
    }

    private void initData(int typeID) {
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                map.put("typeId", "1");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        mList.clear();
                        mList.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
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
                map.put("pageNum", page + "");
                map.put("pageSize", "10");
                map.put("typeId", "1");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        //mList.clear();
                        mList.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
                        adapter.notifyDataSetChanged();
                        page = page + 1;
                    }
                });
            }
        });
        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        map.put("typeId", "1");
        ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                mList = bean.getData().getGovernEnterInteraction().getInteraction();
                adapter = new PolicyInteractionAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(manager);
                recyclerView1.setAdapter(adapter);
                page = 2;
            }
        });

    }

    private void initData2() {
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                map.put("typeId", "2");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        mList2.clear();
                        mList2.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
                        adapter.notifyDataSetChanged();
                        page2 = 2;
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", page2 + "");
                map.put("pageSize", "10");
                map.put("typeId", "2");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        //mList.clear();
                        mList2.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
                        adapter.notifyDataSetChanged();
                        page2 = page2 + 1;
                    }
                });
            }
        });
        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        map.put("typeId", "2");
        ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                mList2 = bean.getData().getGovernEnterInteraction().getInteraction();
                adapter = new PolicyInteractionAdapter(mList2);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(manager);
                recyclerView1.setAdapter(adapter);
                page2 = 2;
            }
        });
    }

    private void initData3() {
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                map.put("typeId", "3");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        mList3.clear();
                        mList3.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
                        adapter.notifyDataSetChanged();
                        page3 = 2;
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", page3 + "");
                map.put("pageSize", "10");
                map.put("typeId", "3");
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                        //mList.clear();
                        mList3.addAll(bean.getData().getGovernEnterInteraction().getInteraction());
                        adapter.notifyDataSetChanged();
                        page3 = page3 + 1;
                    }
                });
            }
        });
        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        map.put("typeId", "3");
        ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                PolicyInteractionBean bean = gson.fromJson(s, PolicyInteractionBean.class);
                mList3 = bean.getData().getGovernEnterInteraction().getInteraction();
                adapter = new PolicyInteractionAdapter(mList3);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView1.setLayoutManager(manager);
                recyclerView1.setAdapter(adapter);
                page3 = 2;
            }
        });
    }

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_search:
                Intent intent = new Intent();
                intent.setClass(context, PolicyInterSercheActivity.class);
                startActivity(intent);
                break;
            case R.id.rl1:
                typeId = "1";
                initData(1);
                tv1.setTextColor(Color.parseColor("#D62424"));
                view1.setVisibility(View.VISIBLE);
                tv2.setTextColor(Color.parseColor("#333333"));
                view2.setVisibility(View.GONE);
                tv3.setTextColor(Color.parseColor("#333333"));
                view3.setVisibility(View.GONE);
                break;
            case R.id.rl2:
                typeId = "2";
                initData2();
                tv1.setTextColor(Color.parseColor("#333333"));
                view1.setVisibility(View.GONE);
                tv2.setTextColor(Color.parseColor("#D62424"));
                view2.setVisibility(View.VISIBLE);
                tv3.setTextColor(Color.parseColor("#333333"));
                view3.setVisibility(View.GONE);
                break;
            case R.id.rl3:
                typeId = "3";
                initData3();
                tv1.setTextColor(Color.parseColor("#333333"));
                view1.setVisibility(View.GONE);
                tv2.setTextColor(Color.parseColor("#333333"));
                view2.setVisibility(View.GONE);
                tv3.setTextColor(Color.parseColor("#D62424"));
                view3.setVisibility(View.VISIBLE);
                break;
        }
    }

}
