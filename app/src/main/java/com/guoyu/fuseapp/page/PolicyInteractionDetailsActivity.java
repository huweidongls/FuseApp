package com.guoyu.fuseapp.page;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.PolicyInteractionDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PolicyInteractionDetailsActivity extends AppCompatActivity {
    private Context context = PolicyInteractionDetailsActivity.this;
    private List<String> mList;
    private PolicyInteractionDetailsAdapter adapter;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_interaction_details);
        ButterKnife.bind(PolicyInteractionDetailsActivity.this);
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        adapter = new PolicyInteractionDetailsAdapter(mList);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
