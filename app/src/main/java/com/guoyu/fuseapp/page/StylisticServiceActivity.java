package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GovernmentListAdapter;
import com.guoyu.fuseapp.adapter.StylisticServiceListAdapter;
import com.guoyu.fuseapp.adapter.Wenti1Adapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.GovernmentListBean;
import com.guoyu.fuseapp.bean.StyleInfoItemqueryListBean;
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
import java.util.Collections;
import java.util.Comparator;
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
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv1)
    TextView tv11;
//    @BindView(R.id.tv2)
//    TextView tv22;
    @BindView(R.id.tv3)
    TextView tv33;

    private String title = "";
    private String funCode = "";
    private StylisticServiceListAdapter adapter;
    private List<StylisticServiceListBean.DataBean.ListsBean> mList;
    private int page = 1;

    private PopupWindow popupWindow;
    private View view;
    private RecyclerView rv;
    private Wenti1Adapter wenti1Adapter;
    private List<StyleInfoItemqueryListBean.DataBean> list;

//    private String type2 = "0";
    private String type3 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylistic_service);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        ButterKnife.bind(StylisticServiceActivity.this);
        initData();
        initShow1();

    }

    private void initShow1() {

        view = LayoutInflater.from(context).inflate(R.layout.popupwindow_wenti1, null);
        rv = view.findViewById(R.id.rv);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "0");
        map.put("pageSize", "0");
        ViseUtil.Post(context, NetUrl.StyleInfoItemqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                StyleInfoItemqueryListBean bean = gson.fromJson(s, StyleInfoItemqueryListBean.class);
                list = bean.getData();
                wenti1Adapter = new Wenti1Adapter(list, new Wenti1Adapter.ClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        popupWindow.dismiss();
                    }
                });
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                rv.setLayoutManager(manager);
                rv.setAdapter(wenti1Adapter);
            }
        });

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

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl3})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl1:
                tv11.setTextColor(Color.parseColor("#D62424"));
                show1();
                break;
//            case R.id.rl2:
//                tv22.setTextColor(Color.parseColor("#D62424"));
//                show2();
//                break;
            case R.id.rl3:
                tv33.setTextColor(Color.parseColor("#D62424"));
                show3();
                break;
        }
    }

    private void show1() {

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        // 设置点击窗口外边窗口消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
//        popupWindow.showAtLocation(cameraView, Gravity.RIGHT|Gravity.BOTTOM, 0, y+20);
        popupWindow.showAsDropDown(ll);
        // 设置popWindow的显示和消失动画
//        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.alpha = 0.5f;
//        getWindow().setAttributes(params);
        popupWindow.update();

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {
//                WindowManager.LayoutParams params = getWindow().getAttributes();
//                params.alpha = 1f;
//                getWindow().setAttributes(params);
//                tvSort.setTextColor(Color.parseColor("#656565"));
//                Glide.with(context).load(R.drawable.to_bottom).into(ivSort);
                tv11.setTextColor(Color.parseColor("#333333"));
            }
        });

    }

//    private void show2() {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_wenti2, null);
//
//        RelativeLayout rl1 = view.findViewById(R.id.rl1);
//        RelativeLayout rl2 = view.findViewById(R.id.rl2);
//        RelativeLayout rl3 = view.findViewById(R.id.rl3);
//        final TextView tv1 = view.findViewById(R.id.tv1);
//        final TextView tv2 = view.findViewById(R.id.tv2);
//        final TextView tv3 = view.findViewById(R.id.tv3);
//        final ImageView iv1 = view.findViewById(R.id.iv1);
//        final ImageView iv2 = view.findViewById(R.id.iv2);
//        final ImageView iv3 = view.findViewById(R.id.iv3);
//
//        if(type2.equals("0")){
//            tv1.setTextColor(Color.parseColor("#D62424"));
//            tv2.setTextColor(Color.parseColor("#333333"));
//            tv3.setTextColor(Color.parseColor("#333333"));
//            iv1.setVisibility(View.VISIBLE);
//            iv2.setVisibility(View.GONE);
//            iv3.setVisibility(View.GONE);
//        }else if(type2.equals("1")){
//            tv1.setTextColor(Color.parseColor("#333333"));
//            tv2.setTextColor(Color.parseColor("#D62424"));
//            tv3.setTextColor(Color.parseColor("#333333"));
//            iv1.setVisibility(View.GONE);
//            iv2.setVisibility(View.VISIBLE);
//            iv3.setVisibility(View.GONE);
//        }else if(type2.equals("2")){
//            tv1.setTextColor(Color.parseColor("#333333"));
//            tv2.setTextColor(Color.parseColor("#333333"));
//            tv3.setTextColor(Color.parseColor("#D62424"));
//            iv1.setVisibility(View.GONE);
//            iv2.setVisibility(View.GONE);
//            iv3.setVisibility(View.VISIBLE);
//        }
//
//        rl1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                type2 = "0";
//                tv22.setText("最新上线");
//                popupWindow.dismiss();
//            }
//        });
//
//        rl2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                type2 = "1";
//                tv22.setText("推荐排序");
//                popupWindow.dismiss();
//            }
//        });
//
//        rl3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                type2 = "2";
//                tv22.setText("人气最高");
//                popupWindow.dismiss();
//            }
//        });
//
//        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
//        popupWindow.setTouchable(true);
//        popupWindow.setFocusable(true);
//        // 设置点击窗口外边窗口消失
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        popupWindow.setOutsideTouchable(true);
////        popupWindow.showAtLocation(cameraView, Gravity.RIGHT|Gravity.BOTTOM, 0, y+20);
//        popupWindow.showAsDropDown(ll);
//        // 设置popWindow的显示和消失动画
////        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
////        WindowManager.LayoutParams params = getWindow().getAttributes();
////        params.alpha = 0.5f;
////        getWindow().setAttributes(params);
//        popupWindow.update();
//
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            // 在dismiss中恢复透明度
//            public void onDismiss() {
////                WindowManager.LayoutParams params = getWindow().getAttributes();
////                params.alpha = 1f;
////                getWindow().setAttributes(params);
////                tvSort.setTextColor(Color.parseColor("#656565"));
////                Glide.with(context).load(R.drawable.to_bottom).into(ivSort);
//                tv22.setTextColor(Color.parseColor("#333333"));
//            }
//        });
//
//    }

    private void show3() {

        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_wenti3, null);

        RelativeLayout rl1 = view.findViewById(R.id.rl1);
        RelativeLayout rl2 = view.findViewById(R.id.rl2);
        RelativeLayout rl3 = view.findViewById(R.id.rl3);
        RelativeLayout rl4 = view.findViewById(R.id.rl4);
        final TextView tv1 = view.findViewById(R.id.tv1);
        final TextView tv2 = view.findViewById(R.id.tv2);
        final TextView tv3 = view.findViewById(R.id.tv3);
        final TextView tv4 = view.findViewById(R.id.tv4);
        final ImageView iv1 = view.findViewById(R.id.iv1);
        final ImageView iv2 = view.findViewById(R.id.iv2);
        final ImageView iv3 = view.findViewById(R.id.iv3);
        final ImageView iv4 = view.findViewById(R.id.iv4);

        if(type3.equals("0")){
            tv1.setTextColor(Color.parseColor("#D62424"));
            tv2.setTextColor(Color.parseColor("#333333"));
            tv3.setTextColor(Color.parseColor("#333333"));
            tv4.setTextColor(Color.parseColor("#333333"));
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
        }else if(type3.equals("1")){
            tv1.setTextColor(Color.parseColor("#333333"));
            tv2.setTextColor(Color.parseColor("#D62424"));
            tv3.setTextColor(Color.parseColor("#333333"));
            tv4.setTextColor(Color.parseColor("#333333"));
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.GONE);
        }else if(type3.equals("2")){
            tv1.setTextColor(Color.parseColor("#333333"));
            tv2.setTextColor(Color.parseColor("#333333"));
            tv3.setTextColor(Color.parseColor("#D62424"));
            tv4.setTextColor(Color.parseColor("#333333"));
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.GONE);
        }else if(type3.equals("3")){
            tv1.setTextColor(Color.parseColor("#333333"));
            tv2.setTextColor(Color.parseColor("#333333"));
            tv3.setTextColor(Color.parseColor("#333333"));
            tv4.setTextColor(Color.parseColor("#D62424"));
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.GONE);
            iv3.setVisibility(View.GONE);
            iv4.setVisibility(View.VISIBLE);
        }

        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type3 = "0";
                tv33.setText("全部时间");
                popupWindow.dismiss();
            }
        });

        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type3 = "1";
                tv33.setText("一周内");
                popupWindow.dismiss();
            }
        });

        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type3 = "2";
                tv33.setText("一个月内");
                popupWindow.dismiss();
            }
        });

        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type3 = "3";
                tv33.setText("三个月内");
                popupWindow.dismiss();
            }
        });

        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        // 设置点击窗口外边窗口消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
//        popupWindow.showAtLocation(cameraView, Gravity.RIGHT|Gravity.BOTTOM, 0, y+20);
        popupWindow.showAsDropDown(ll);
        // 设置popWindow的显示和消失动画
//        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.alpha = 0.5f;
//        getWindow().setAttributes(params);
        popupWindow.update();

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            // 在dismiss中恢复透明度
            public void onDismiss() {
//                WindowManager.LayoutParams params = getWindow().getAttributes();
//                params.alpha = 1f;
//                getWindow().setAttributes(params);
//                tvSort.setTextColor(Color.parseColor("#656565"));
//                Glide.with(context).load(R.drawable.to_bottom).into(ivSort);
                tv33.setTextColor(Color.parseColor("#333333"));
            }
        });

    }

}
