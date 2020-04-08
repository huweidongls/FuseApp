package com.guoyu.fuseapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.WeiguanAdapter;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.WeiguanListBean;
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

/**
 * Created by Administrator on 2019/10/15.
 */

public class FragmentWeiguan extends BaseFragment {

    @BindView(R.id.refreshs)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;

    public static FragmentWeiguan newInstance(String id) {
        FragmentWeiguan newFragment = new FragmentWeiguan();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    private String id = "";

    private int page = 1;

    private WeiguanAdapter adapter;
    private List<WeiguanListBean.DataBean> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weiguan, null);

        ButterKnife.bind(this, view);
        Bundle args = getArguments();
        if (args != null) {
            id = args.getString("id");
        }
        initData();

        return view;
    }

    private void initData() {

        smartRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(getContext()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                if(id.equals("0")){
                    map.put("pageNum", "1");
                    map.put("pageSize", "10");
                    map.put("state", "0");
                }else if(id.equals("1")){
                    map.put("pageNum", "1");
                    map.put("pageSize", "10");
                    map.put("state", "1");
                }else if(id.equals("2")){
                    map.put("pageNum", "1");
                    map.put("pageSize", "10");
                    map.put("state", "2");
                    map.put("userId", SpUtils.getUserId(getContext()));
                }
                ViseUtil.Get(getContext(), NetUrl.AppMiniCityInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        WeiguanListBean bean = gson.fromJson(s, WeiguanListBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                    }
                });
                refreshLayout.finishRefresh(1000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                if(id.equals("0")){
                    map.put("pageNum", page+"");
                    map.put("pageSize", "10");
                    map.put("state", "0");
                }else if(id.equals("1")){
                    map.put("pageNum", page+"");
                    map.put("pageSize", "10");
                    map.put("state", "1");
                }else if(id.equals("2")){
                    map.put("pageNum", page+"");
                    map.put("pageSize", "10");
                    map.put("state", "2");
                    map.put("userId", SpUtils.getUserId(getContext()));
                }
                ViseUtil.Get(getContext(), NetUrl.AppMiniCityInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        WeiguanListBean bean = gson.fromJson(s, WeiguanListBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page + 1;
                    }
                });
                refreshLayout.finishLoadMore(1000);
            }
        });
        Map<String, String> map = new LinkedHashMap<>();
        if(id.equals("0")){
            map.put("pageNum", "1");
            map.put("pageSize", "10");
            map.put("state", "0");
        }else if(id.equals("1")){
            map.put("pageNum", "1");
            map.put("pageSize", "10");
            map.put("state", "1");
        }else if(id.equals("2")){
            map.put("pageNum", "1");
            map.put("pageSize", "10");
            map.put("state", "2");
            map.put("userId", SpUtils.getUserId(getContext()));
        }
        ViseUtil.Get(getContext(), NetUrl.AppMiniCityInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                WeiguanListBean bean = gson.fromJson(s, WeiguanListBean.class);
                mList = bean.getData();
                adapter = new WeiguanAdapter(mList, id);
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                page = 2;
                if (mList.size() > 0) {
                    empty_order_bloacks.setVisibility(View.GONE);
                    smartRefreshLayout.setVisibility(View.VISIBLE);
                } else {
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    smartRefreshLayout.setVisibility(View.GONE);
//                    smartRefreshLayout.setEnableRefresh(false);
//                    smartRefreshLayout.setEnableLoadMore(false);
                }
            }
        });

    }

}
