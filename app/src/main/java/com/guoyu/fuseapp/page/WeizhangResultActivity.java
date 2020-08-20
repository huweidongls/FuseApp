package com.guoyu.fuseapp.page;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.WeizhangListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.WeizhangBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeizhangResultActivity extends BaseActivity {

    private Context context = WeizhangResultActivity.this;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.tv_number)
    TextView tvNumber;

    private String title = "";

    private WeizhangListAdapter adapter;
    private List<WeizhangBean.DataBean> mList;

    private WeizhangBean bean;
    private String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weizhang_result);

        number = getIntent().getStringExtra("number");
        title = getIntent().getStringExtra("title");
        bean = (WeizhangBean) getIntent().getSerializableExtra("bean");
        ButterKnife.bind(WeizhangResultActivity.this);
        initData();

    }

    private void initData() {

        tvTitle.setText(title);
        tvNumber.setText(number);

        mList = bean.getData();
        adapter = new WeizhangListAdapter(mList);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

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
