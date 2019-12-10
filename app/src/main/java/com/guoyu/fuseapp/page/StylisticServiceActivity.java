package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GovernmentListAdapter;
import com.guoyu.fuseapp.adapter.StylisticServiceListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.GovernmentListBean;
import com.guoyu.fuseapp.bean.StylisticServiceListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.Logger;
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

public class StylisticServiceActivity extends BaseActivity {

    private Context context = StylisticServiceActivity.this;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.refreshs)
    SmartRefreshLayout refreshs;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    @BindView(R.id.iv_title_img)
    ImageView iv_title_img;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String title = "";
    private String funCode = "";
    private StylisticServiceListAdapter adapter;
    private List<StylisticServiceListBean.DataBean.ListsBean> mList;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylistic_service);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        ButterKnife.bind(StylisticServiceActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);
        refreshs.setRefreshHeader(new MaterialHeader(StylisticServiceActivity.this));
        refreshs.setRefreshFooter(new ClassicsFooter(StylisticServiceActivity.this));
        refreshs.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                ViseUtil.Post(StylisticServiceActivity.this, NetUrl.AppStyleInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        StylisticServiceListBean bean = gson.fromJson(s, StylisticServiceListBean.class);
                        mList.clear();
                        mList.addAll(bean.getData().getLists());
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
                ViseUtil.Post(StylisticServiceActivity.this, NetUrl.AppStyleInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        StylisticServiceListBean bean = gson.fromJson(s, StylisticServiceListBean.class);
                        mList.addAll(bean.getData().getLists());
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
        ViseUtil.Post(context, NetUrl.AppStyleInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                StylisticServiceListBean bean = gson.fromJson(s, StylisticServiceListBean.class);
                if(bean.getData().getPicture()!=null){
                    String[] pics = bean.getData().getPicture().split(",");
                    if(pics.length>0){
                        GlideUtils.into(context, NetUrl.BASE_URL + pics[0], iv_title_img);
                    }
                }
                mList = bean.getData().getLists();
                adapter = new StylisticServiceListAdapter(mList, title, funCode);
                LinearLayoutManager manager = new LinearLayoutManager(StylisticServiceActivity.this) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler_view.setLayoutManager(manager);
                recycler_view.setAdapter(adapter);
                page = 2;
                if (mList.size() > 0) {
                    refreshs.setVisibility(View.VISIBLE);
                    empty_order_bloacks.setVisibility(View.GONE);
                } else {
                    refreshs.setVisibility(View.GONE);
                    empty_order_bloacks.setVisibility(View.VISIBLE);
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
