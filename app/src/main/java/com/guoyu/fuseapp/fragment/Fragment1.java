package com.guoyu.fuseapp.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.ConvenienceNoticeAdapter;
import com.guoyu.fuseapp.adapter.IndexAdapter;
import com.guoyu.fuseapp.adapter.IndexGongnengAdapter;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.AppCitizenIndexfindConvenienceNoticeBean;
import com.guoyu.fuseapp.bean.AppCitizenIndexfindConvenienceQueryBean;
import com.guoyu.fuseapp.bean.BannerBean;
import com.guoyu.fuseapp.bean.ConvenienceNoticeBean;
import com.guoyu.fuseapp.bean.IndexBean;
import com.guoyu.fuseapp.bean.IndexGongnengBean;
import com.guoyu.fuseapp.bean.IndexZwznBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.CommunityServiceActivity;
import com.guoyu.fuseapp.page.GobernmentContentActivity;
import com.guoyu.fuseapp.page.GovernmentListActivity;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.ModuleWebViewActivity;
import com.guoyu.fuseapp.page.SearchActivity;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.widget.ScrollTextView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/9/29.
 */

public class Fragment1 extends BaseFragment {

    @BindView(R.id.rv_gongneng)
    RecyclerView rvGongneng;
    @BindView(R.id.tv_zw1)
    ScrollTextView tvZw1;
    @BindView(R.id.tv_zw2)
    ScrollTextView tvZw2;
//    @BindView(R.id.view1)
//    View view1;
//    @BindView(R.id.view2)
//    View view2;
//    @BindView(R.id.view3)
//    View view3;
//    @BindView(R.id.tv1)
//    TextView tv1;
//    @BindView(R.id.tv2)
//    TextView tv2;
//    @BindView(R.id.tv3)
//    TextView tv3;
    @BindView(R.id.rv1)
    RecyclerView rv1;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
//    @BindView(R.id.tv_xiaoqu_name)
//    TextView tvXiaoquName;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;

    private IndexGongnengAdapter gongnengAdapter;
    private List<IndexGongnengBean.DataBean> mList;
//    private IndexAdapter indexAdapter1;
//    private IndexAdapter indexAdapter2;
//    private IndexAdapter indexAdapter3;
//    private List<IndexBean.DataBean> mList1;
//    private List<IndexBean.DataBean> mList2;
//    private List<IndexBean.DataBean> mList3;
//
//    private String fun1 = "";
//    private String fun2 = "";
//    private String fun3 = "";

    private ConvenienceNoticeAdapter adapter1;
    private List<ConvenienceNoticeBean.DataBean> mList1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);

        ButterKnife.bind(this, view);
        initRefresh();
        initGongneng();
        initData();

        return view;
    }

    /**
     * 初始化下拉刷新
     */
    private void initRefresh() {

        smartRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()));
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initGongneng();
                initData();
                refreshLayout.finishRefresh(1000);
            }
        });

    }

    /**
     * 功能模块
     */
    private void initGongneng() {

        ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindAllInfo, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                IndexGongnengBean bean = gson.fromJson(s, IndexGongnengBean.class);
                mList = bean.getData();gongnengAdapter = new IndexGongnengAdapter(mList);
                GridLayoutManager manager = new GridLayoutManager(getContext(), 4){
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                rvGongneng.setLayoutManager(manager);
                rvGongneng.setAdapter(gongnengAdapter);
            }
        });

    }

    private void initData() {

        //加载所属社区名称
//        tvXiaoquName.setText(SpUtils.getShequName(getContext()));
        //政务指南
        ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindNewGovernment, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                final IndexZwznBean zwznBean = gson.fromJson(s, IndexZwznBean.class);
                List<String> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                for (IndexZwznBean.DataBean.List1Bean bean : zwznBean.getData().getList1()){
                    list1.add(bean.getTitle());
                }
                for (IndexZwznBean.DataBean.List2Bean bean : zwznBean.getData().getList2()){
                    list2.add(bean.getTitle());
                }
                if(list1.size()>0){
                    tvZw1.setList(list1);
                    tvZw1.startScroll();
                }
                if(list2.size()>0){
                    tvZw2.setList(list2);
                    tvZw2.startScroll();
                }
                tvZw1.setOnSelectListener(new ScrollTextView.OnSelectListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(), GobernmentContentActivity.class);
                        intent.putExtra("id", zwznBean.getData().getList1().get(pos).getId()+"");
                        intent.putExtra("title", "政务指南");
                        intent.putExtra("funcode", "ZWZN");
                        startActivity(intent);
                    }
                });
                tvZw2.setOnSelectListener(new ScrollTextView.OnSelectListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(), GobernmentContentActivity.class);
                        intent.putExtra("id", zwznBean.getData().getList2().get(pos).getId()+"");
                        intent.putExtra("title", "政务指南");
                        intent.putExtra("funcode", "ZWZN");
                        startActivity(intent);
                    }
                });
            }
        });

        //便民服务
        ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindConvenienceNotice, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                final AppCitizenIndexfindConvenienceNoticeBean bean = gson.fromJson(s, AppCitizenIndexfindConvenienceNoticeBean.class);
                if(bean.getData().size()>1){
                    GlideUtils.into(getContext(), NetUrl.BASE_URL+bean.getData().get(0).getShowPic(), iv1);
                    GlideUtils.into(getContext(), NetUrl.BASE_URL+bean.getData().get(1).getShowPic(), iv2);
                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppCitizenIndexfindConvenienceNoticeBean.DataBean a = bean.getData().get(0);
                            Intent intent = new Intent();
                            if(a.getUnregSee() == 0){
                                if(SpUtils.getUserId(getContext()).equals("0")){
                                    intent.setClass(getContext(), LoginActivity.class);
                                    startActivity(intent);
                                }else if(a.getUrl() == null){
                                    try {
                                        intent.setClass(getContext(), Class.forName(a.getAndroidUrl()));
                                        intent.putExtra("title", a.getFunName());
                                        startActivity(intent);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    intent.setClass(getContext(), ModuleWebViewActivity.class);
                                    intent.putExtra("title", a.getFunName());
                                    intent.putExtra("url", a.getUrl());
                                    startActivity(intent);
                                }
                            }else {
                                if(a.getUrl() == null){
                                    try {
                                        intent.setClass(getContext(), Class.forName(a.getAndroidUrl()));
                                        intent.putExtra("title", a.getFunName());
                                        startActivity(intent);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    intent.setClass(getContext(), ModuleWebViewActivity.class);
                                    intent.putExtra("title", a.getFunName());
                                    intent.putExtra("url", a.getUrl());
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                    iv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppCitizenIndexfindConvenienceNoticeBean.DataBean b = bean.getData().get(1);
                            Intent intent = new Intent();
                            if(b.getUnregSee() == 0){
                                if(SpUtils.getUserId(getContext()).equals("0")){
                                    intent.setClass(getContext(), LoginActivity.class);
                                    startActivity(intent);
                                }else if(b.getUrl() == null){
                                    try {
                                        intent.setClass(getContext(), Class.forName(b.getAndroidUrl()));
                                        intent.putExtra("title", b.getFunName());
                                        startActivity(intent);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    intent.setClass(getContext(), ModuleWebViewActivity.class);
                                    intent.putExtra("title", b.getFunName());
                                    intent.putExtra("url", b.getUrl());
                                    startActivity(intent);
                                }
                            }else {
                                if(b.getUrl() == null){
                                    try {
                                        intent.setClass(getContext(), Class.forName(b.getAndroidUrl()));
                                        intent.putExtra("title", b.getFunName());
                                        startActivity(intent);
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    intent.setClass(getContext(), ModuleWebViewActivity.class);
                                    intent.putExtra("title", b.getFunName());
                                    intent.putExtra("url", b.getUrl());
                                    startActivity(intent);
                                }
                            }
                        }
                    });
                }
            }
        });

        //便民查询
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageSize", "0");
        map.put("pageNum", "0");
        map.put("title", "");
        ViseUtil.Post(getContext(), NetUrl.AppConvenienceNoticequeryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                ConvenienceNoticeBean bean = gson.fromJson(s, ConvenienceNoticeBean.class);
                mList1 = bean.getData();
                adapter1 = new ConvenienceNoticeAdapter(mList1, "便民通知", "BMTZ");
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                rv1.setLayoutManager(manager);
                rv1.setAdapter(adapter1);
            }
        });

//        ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindConvenienceQuery, null, new ViseUtil.ViseListener() {
//            @Override
//            public void onReturn(String s) {
//                Gson gson = new Gson();
//                AppCitizenIndexfindConvenienceQueryBean queryBean = gson.fromJson(s, AppCitizenIndexfindConvenienceQueryBean.class);
//                List<AppCitizenIndexfindConvenienceQueryBean.DataBean> list = queryBean.getData();
//                if(list.size()>2){
//                    tv1.setText(list.get(0).getFunName());
//                    tv2.setText(list.get(1).getFunName());
//                    tv3.setText(list.get(2).getFunName());
//                    fun1 = list.get(0).getRelationTable();
//                    fun2 = list.get(1).getRelationTable();
//                    fun3 = list.get(2).getRelationTable();
//                    Map<String, String> map = new LinkedHashMap<>();
//                    map.put("relationTable", fun1);
//                    ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindByFunCode, map, new ViseUtil.ViseListener() {
//                        @Override
//                        public void onReturn(String s) {
//                            Logger.e("123123", s);
//                            Gson gson1 = new Gson();
//                            IndexBean bean = gson1.fromJson(s, IndexBean.class);
//                            mList1 = bean.getData();
//                            indexAdapter1 = new IndexAdapter(mList1);
//                            LinearLayoutManager manager = new LinearLayoutManager(getContext()){
//                                @Override
//                                public boolean canScrollVertically() {
//                                    return false;
//                                }
//                            };
//                            manager.setOrientation(LinearLayoutManager.VERTICAL);
//                            rv1.setLayoutManager(manager);
//                            rv1.setAdapter(indexAdapter1);
//                        }
//                    });
//                    Map<String, String> map1 = new LinkedHashMap<>();
//                    map1.put("relationTable", fun2);
//                    ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindByFunCode, map1, new ViseUtil.ViseListener() {
//                        @Override
//                        public void onReturn(String s) {
//                            Gson gson1 = new Gson();
//                            IndexBean bean = gson1.fromJson(s, IndexBean.class);
//                            mList2 = bean.getData();
//                            indexAdapter2 = new IndexAdapter(mList2);
//                            LinearLayoutManager manager = new LinearLayoutManager(getContext()){
//                                @Override
//                                public boolean canScrollVertically() {
//                                    return false;
//                                }
//                            };
//                            manager.setOrientation(LinearLayoutManager.VERTICAL);
//                            rv2.setLayoutManager(manager);
//                            rv2.setAdapter(indexAdapter2);
//                        }
//                    });
//                    Map<String, String> map2 = new LinkedHashMap<>();
//                    map2.put("relationTable", fun3);
//                    ViseUtil.Post(getContext(), NetUrl.AppCitizenIndexfindByFunCode, map2, new ViseUtil.ViseListener() {
//                        @Override
//                        public void onReturn(String s) {
//                            Gson gson1 = new Gson();
//                            IndexBean bean = gson1.fromJson(s, IndexBean.class);
//                            mList3 = bean.getData();
//                            indexAdapter3 = new IndexAdapter(mList3);
//                            LinearLayoutManager manager = new LinearLayoutManager(getContext()){
//                                @Override
//                                public boolean canScrollVertically() {
//                                    return false;
//                                }
//                            };
//                            manager.setOrientation(LinearLayoutManager.VERTICAL);
//                            rv3.setLayoutManager(manager);
//                            rv3.setAdapter(indexAdapter3);
//                        }
//                    });
//                }
//            }
//        });

    }

    @OnClick({R.id.rl_search, R.id.rl_top1, R.id.rl_top2, R.id.rl_top3, R.id.rl_top4})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_top1:
                intent.setClass(getContext(), GovernmentListActivity.class);
                intent.putExtra("funcode", "ZWZN");
                intent.putExtra("title", "政务指南");
                startActivity(intent);
                break;
            case R.id.rl_top2:
                intent.setClass(getContext(), ModuleWebViewActivity.class);
                intent.putExtra("funcode", "YLBJ");
                intent.putExtra("url", "http://xfsysh5.5ijiaoyu.cn/pages/yiliao.html");
                startActivity(intent);
                break;
            case R.id.rl_top3:
                intent.setClass(getContext(), ModuleWebViewActivity.class);
                intent.putExtra("funcode", "XKZY");
                intent.putExtra("url", "http://xfsysh5.5ijiaoyu.cn/pages/jyo_pages/jyo_list.html");
                startActivity(intent);
                break;
            case R.id.rl_top4:
                intent.setClass(getContext(), ModuleWebViewActivity.class);
                intent.putExtra("funcode", "ZPFW");
                intent.putExtra("url", "http://xfsysh5.5ijiaoyu.cn/pages/zp_list.html");
                startActivity(intent);
                break;
//            case R.id.rl1:
//                tv1.setTextColor(getResources().getColor(R.color.theme));
//                tv2.setTextColor(Color.parseColor("#000000"));
//                tv3.setTextColor(Color.parseColor("#000000"));
//                view1.setVisibility(View.VISIBLE);
//                view2.setVisibility(View.GONE);
//                view3.setVisibility(View.GONE);
//                rv1.setVisibility(View.VISIBLE);
//                rv2.setVisibility(View.GONE);
//                rv3.setVisibility(View.GONE);
//                break;
//            case R.id.rl2:
//                tv1.setTextColor(Color.parseColor("#000000"));
//                tv2.setTextColor(getResources().getColor(R.color.theme));
//                tv3.setTextColor(Color.parseColor("#000000"));
//                view1.setVisibility(View.GONE);
//                view2.setVisibility(View.VISIBLE);
//                view3.setVisibility(View.GONE);
//                rv1.setVisibility(View.GONE);
//                rv2.setVisibility(View.VISIBLE);
//                rv3.setVisibility(View.GONE);
//                break;
//            case R.id.rl3:
//                tv1.setTextColor(Color.parseColor("#000000"));
//                tv2.setTextColor(Color.parseColor("#000000"));
//                tv3.setTextColor(getResources().getColor(R.color.theme));
//                view1.setVisibility(View.GONE);
//                view2.setVisibility(View.GONE);
//                view3.setVisibility(View.VISIBLE);
//                rv1.setVisibility(View.GONE);
//                rv2.setVisibility(View.GONE);
//                rv3.setVisibility(View.VISIBLE);
//                break;
            case R.id.rl_search:
                intent.setClass(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
//            case R.id.ll_shequ:
//                if(SpUtils.getUserId(getContext()).equals("0")){
//                    intent.setClass(getContext(), LoginActivity.class);
//                    startActivity(intent);
//                }else {
//                    intent.setClass(getContext(), CommunityServiceActivity.class);
//                    intent.putExtra("title", "社区服务");
//                    intent.putExtra("funcode", "SQFW");
//                    startActivity(intent);
//                }
//                break;
        }
    }

}
