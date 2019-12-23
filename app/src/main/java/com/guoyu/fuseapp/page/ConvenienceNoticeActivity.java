package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.ConvenienceNoticeAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.ConvenienceNoticeBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConvenienceNoticeActivity extends BaseActivity {

    private Context context = ConvenienceNoticeActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private ConvenienceNoticeAdapter adapter;
    private List<ConvenienceNoticeBean.DataBean> mList;

    private String title = "";
    private String funCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convenience_notice);

        funCode = getIntent().getStringExtra("funcode");
        title = getIntent().getStringExtra("title");
        ButterKnife.bind(ConvenienceNoticeActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageSize", "0");
        map.put("pageNum", "0");
        map.put("title", "");
        ViseUtil.Post(context, NetUrl.AppConvenienceNoticequeryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Logger.e("123123", s);
                Gson gson = new Gson();
                ConvenienceNoticeBean bean = gson.fromJson(s, ConvenienceNoticeBean.class);
                mList = bean.getData();
                adapter = new ConvenienceNoticeAdapter(mList, title, funCode);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
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
