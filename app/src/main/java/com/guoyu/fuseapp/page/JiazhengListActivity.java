package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.JaizhengListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.JaizhengListBean;
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

    private JaizhengListAdapter adapter;
    private List<JaizhengListBean.DataBean> mList;

    private int page = 1;
    private String title = "";

    private Dialog dialog;
    private String topTitle = "";
    private String funCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiazheng_list);

        funCode = getIntent().getStringExtra("funcode");
        topTitle = getIntent().getStringExtra("title");
        ButterKnife.bind(JiazhengListActivity.this);
        initData();

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
                map.put("title", title);
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
                map.put("title", title);
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
        map.put("title", title);
        ViseUtil.Get(context, NetUrl.AppHouseServiceInfoqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                JaizhengListBean bean = gson.fromJson(s, JaizhengListBean.class);
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

    @OnClick({R.id.rl_back, R.id.iv_btn})
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
        }
    }

}
