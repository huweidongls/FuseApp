package com.guoyu.fuseapp.page;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GovernmentListAdapter;
import com.guoyu.fuseapp.adapter.PolicyInteractionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PolicyInteractionActivity extends AppCompatActivity {
    private Context context = PolicyInteractionActivity.this;
    private List<String> mList;
    private PolicyInteractionAdapter adapter;
    @BindView(R.id.rv)
    RecyclerView recyclerView1;
    @BindView(R.id.rv2)
    RecyclerView recyclerView2;
    @BindView(R.id.rv3)
    RecyclerView recyclerView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_interaction);
        ButterKnife.bind(PolicyInteractionActivity.this);
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        adapter = new PolicyInteractionAdapter(mList);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(manager);
        recyclerView1.setAdapter(adapter);
    }
}
