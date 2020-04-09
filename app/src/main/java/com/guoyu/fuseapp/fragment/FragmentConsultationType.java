package com.guoyu.fuseapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.FragmentConsultationTypeAdapter;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.ConsultationTypeBean;
import com.guoyu.fuseapp.net.NetUrl;
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
 * Created by Administrator on 2019/10/9.
 */

public class FragmentConsultationType extends BaseFragment {

    public static FragmentConsultationType newInstance(String code) {
        FragmentConsultationType newFragment = new FragmentConsultationType();
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.ll_list)
    LinearLayout ll_list;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    private int page = 1;
    @BindView(R.id.refreshs)
    SmartRefreshLayout smartRefreshLayout;

    private boolean isFirst = true;
    private String code = "";
    private FragmentConsultationTypeAdapter adapter;
    private List<ConsultationTypeBean.DataBean> mList;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consultation_type, null);
        ButterKnife.bind(this, view);
        Bundle args = getArguments();
        if (args != null) {
            code = args.getString("code");
        }
        initData();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isFirst) {
            isFirst = false;
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("userId", SpUtils.getUserId(getContext()));
            map.put("type", code);
            map.put("pageNum", "1");
            map.put("pageSize", "10");
            ViseUtil.Get(getContext(), NetUrl.AppConsultationInfoqueryList, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    Gson gson = new Gson();
                    ConsultationTypeBean bean = gson.fromJson(s, ConsultationTypeBean.class);
                    mList = bean.getData();
                    if (mList.size() > 0) {
                        adapter = new FragmentConsultationTypeAdapter(mList);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(adapter);
                        page = 2;
                        empty_order_bloacks.setVisibility(View.GONE);
                        ll_list.setVisibility(View.VISIBLE);
                    } else {
                        empty_order_bloacks.setVisibility(View.VISIBLE);
                        ll_list.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    private void initData() {
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(getContext()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("userId", SpUtils.getUserId(getContext()));
                map.put("type", code);
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                ViseUtil.Get(getContext(), NetUrl.AppConsultationInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        ConsultationTypeBean bean = gson.fromJson(s, ConsultationTypeBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                        refreshLayout.finishRefresh(500);
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("userId", SpUtils.getUserId(getContext()));
                map.put("type", code);
                map.put("pageNum", page + "");
                map.put("pageSize", "10");
                ViseUtil.Get(getContext(), NetUrl.AppConsultationInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        ConsultationTypeBean bean = gson.fromJson(s, ConsultationTypeBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page + 1;
                        refreshLayout.finishLoadMore(500);
                    }
                });

            }
        });
        Map<String, String> map = new LinkedHashMap<>();
        map.put("userId", SpUtils.getUserId(getContext()));
        map.put("type", code);
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        ViseUtil.Get(getContext(), NetUrl.AppConsultationInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                ConsultationTypeBean bean = gson.fromJson(s, ConsultationTypeBean.class);
                mList = bean.getData();
                adapter = new FragmentConsultationTypeAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                page = 2;
                if (mList.size() > 0) {
                    empty_order_bloacks.setVisibility(View.GONE);
                    ll_list.setVisibility(View.VISIBLE);
                } else {
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    ll_list.setVisibility(View.GONE);
                }
            }
        });
    }

}
