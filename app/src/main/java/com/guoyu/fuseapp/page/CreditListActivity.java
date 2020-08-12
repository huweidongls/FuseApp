package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.CreditDetailsAdapter;
import com.guoyu.fuseapp.adapter.CreditListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.CreditBean;
import com.guoyu.fuseapp.bean.SyscreditBean;
import com.guoyu.fuseapp.util.Logger;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditListActivity extends BaseActivity {

    private Context context = CreditListActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private String name = "";
    private String title = "";

    private int page = 1;

    private CreditListAdapter adapter;
    private List<SyscreditBean.RowsBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_list);

        name = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        ButterKnife.bind(CreditListActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(context));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(context));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                String url = "/publicity/data_list.json?configId=_precast_pub_code&conditions=%7B\"unifiedCode\":\"\",\"id\":\"\",\"compName\":\""+name+"\"%7D&currentPage="+1+"&pageSize=10";
//        String url = "/publicity/data_list.json";
                ViseHttp.GET(url)
                        .baseUrl("http://www.syscredit.gov.cn/")
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                Gson gson = new Gson();
                                SyscreditBean bean = gson.fromJson(data, SyscreditBean.class);
                                mList.clear();
                                mList.addAll(bean.getRows());
                                adapter.notifyDataSetChanged();
                                page = 2;
                                refreshLayout.finishRefresh(500);
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {
                                Logger.e("123123", errMsg);
                                refreshLayout.finishRefresh(500);
                            }
                        });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                String url = "/publicity/data_list.json?configId=_precast_pub_code&conditions=%7B\"unifiedCode\":\"\",\"id\":\"\",\"compName\":\""+name+"\"%7D&currentPage="+page+"&pageSize=10";
//        String url = "/publicity/data_list.json";
                ViseHttp.GET(url)
                        .baseUrl("http://www.syscredit.gov.cn/")
                        .request(new ACallback<String>() {
                            @Override
                            public void onSuccess(String data) {
                                Logger.e("123123", data);
                                Gson gson = new Gson();
                                SyscreditBean bean = gson.fromJson(data, SyscreditBean.class);
                                mList.addAll(bean.getRows());
                                adapter.notifyDataSetChanged();
                                page = page + 1;
                                refreshLayout.finishLoadMore(500);
                            }

                            @Override
                            public void onFail(int errCode, String errMsg) {
                                Logger.e("123123", errMsg);
                                refreshLayout.finishLoadMore(500);
                            }
                        });
            }
        });

        String url = "/publicity/data_list.json?configId=_precast_pub_code&conditions=%7B\"unifiedCode\":\"\",\"id\":\"\",\"compName\":\""+name+"\"%7D&currentPage="+page+"&pageSize=10";
//        String url = "/publicity/data_list.json";
        ViseHttp.GET(url)
                .baseUrl("http://www.syscredit.gov.cn/")
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Logger.e("123123", data);
                        Gson gson = new Gson();
                        SyscreditBean bean = gson.fromJson(data, SyscreditBean.class);
                        mList = bean.getRows();
                        adapter = new CreditListAdapter(mList);
                        LinearLayoutManager manager = new LinearLayoutManager(context);
                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(adapter);
                        page = 2;
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Logger.e("123123", errMsg);
                    }
                });

    }

    @OnClick({R.id.rl_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

}
