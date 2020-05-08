package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.JaizhengListAdapter;
import com.guoyu.fuseapp.adapter.Jiazheng1Adapter;
import com.guoyu.fuseapp.adapter.Wenti1Adapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.HouseServiceInfoItemAppqueryListAppBean;
import com.guoyu.fuseapp.bean.JaizhengListBean;
import com.guoyu.fuseapp.bean.StyleInfoItemqueryListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;
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

public class JiazhengListActivity extends BaseActivity {

    private Context context = JiazhengListActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.et_titles)
    EditText etSearch;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout rlEmpty;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv1)
    TextView tv11;
    @BindView(R.id.tv2)
    TextView tv22;

    private JaizhengListAdapter adapter;
    private List<JaizhengListBean.DataBean> mList;

    private int page = 1;
    private String title = "";

    private Dialog dialog;
    private String topTitle = "";
    private String funCode = "";

    private PopupWindow popupWindow;
    private View view;
    private RecyclerView rv;
    private Jiazheng1Adapter wenti1Adapter;
    private List<HouseServiceInfoItemAppqueryListAppBean.DataBean> list;
    private String type = "";
    private String px = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiazheng_list);

        funCode = getIntent().getStringExtra("funcode");
        topTitle = getIntent().getStringExtra("title");
        ButterKnife.bind(JiazhengListActivity.this);
        initData();
        initShow1();

    }

    private void initShow1() {

        view = LayoutInflater.from(context).inflate(R.layout.popupwindow_wenti1, null);
        rv = view.findViewById(R.id.rv);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "0");
        map.put("pageSize", "0");
        ViseUtil.Post(context, NetUrl.HouseServiceInfoItemAppqueryListApp, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                HouseServiceInfoItemAppqueryListAppBean bean = gson.fromJson(s, HouseServiceInfoItemAppqueryListAppBean.class);
                list = bean.getData();
                list.add(0, new HouseServiceInfoItemAppqueryListAppBean.DataBean("全部"));
                wenti1Adapter = new Jiazheng1Adapter(list, new Jiazheng1Adapter.ClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        if(pos == 0){
                            type = "";
                        }else {
                            type = list.get(pos).getId()+"";
                        }
                        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                        initData();
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

        tvTitle.setText(topTitle);
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageSize", "10");
                map.put("pageNum", "1");
                if(!StringUtils.isEmpty(type)){
                    map.put("type", type);
                }
                if(!StringUtils.isEmpty(px)){
                    map.put("px", px);
                }
//                map.put("title", title);
                ViseUtil.Get(context, NetUrl.AppHouseServiceInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        JaizhengListBean bean = gson.fromJson(s, JaizhengListBean.class);
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
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageSize", "10");
                map.put("pageNum", page+"");
//                map.put("title", title);
                if(!StringUtils.isEmpty(type)){
                    map.put("type", type);
                }
                if(!StringUtils.isEmpty(px)){
                    map.put("px", px);
                }
                ViseUtil.Get(context, NetUrl.AppHouseServiceInfoqueryList, map, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        JaizhengListBean bean = gson.fromJson(s, JaizhengListBean.class);
                        mList.addAll(bean.getData());
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
//        map.put("title", title);
        if(!StringUtils.isEmpty(type)){
            map.put("type", type);
        }
        if(!StringUtils.isEmpty(px)){
            map.put("px", px);
        }
        ViseUtil.Get(context, NetUrl.AppHouseServiceInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                JaizhengListBean bean = gson.fromJson(s, JaizhengListBean.class);
                WeiboDialogUtils.closeDialog(dialog);
                mList = bean.getData();
                if(mList.size()>0){
                    adapter = new JaizhengListAdapter(mList, topTitle, funCode);
                    LinearLayoutManager manager = new LinearLayoutManager(context);
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    smartRefreshLayout.setVisibility(View.VISIBLE);
                    rlEmpty.setVisibility(View.GONE);
                }else {
                    smartRefreshLayout.setVisibility(View.GONE);
                    rlEmpty.setVisibility(View.VISIBLE);
                }
                page = 2;
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.iv_btn, R.id.rl1, R.id.rl2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_btn:
                dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                title = etSearch.getText().toString();
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageSize", "10");
                map.put("pageNum", "1");
                map.put("title", title);
                ViseUtil.Get(context, NetUrl.AppHouseServiceInfoqueryList, map, dialog, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        JaizhengListBean bean = gson.fromJson(s, JaizhengListBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        if(mList.size()>0){
                            smartRefreshLayout.setVisibility(View.VISIBLE);
                            rlEmpty.setVisibility(View.GONE);
                        }else {
                            smartRefreshLayout.setVisibility(View.GONE);
                            rlEmpty.setVisibility(View.VISIBLE);
                        }
                        page = 2;
                    }
                });
                break;
            case R.id.rl1:
                tv11.setTextColor(getResources().getColor(R.color.theme));
                show1();
                break;
            case R.id.rl2:
                if(StringUtils.isEmpty(px)){
                    px = "1";
                    tv22.setText("由高到低");
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    initData();
                }else if(px.equals("1")){
                    px = "2";
                    tv22.setText("由低到高");
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    initData();
                }else if(px.equals("2")){
                    px = "";
                    tv22.setText("价格排序");
                    dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
                    initData();
                }
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

}
