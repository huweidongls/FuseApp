package com.guoyu.fuseapp.page;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.GovernmentListAdapter;
import com.guoyu.fuseapp.adapter.PolicyInteractionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PolicyInteractionActivity extends AppCompatActivity {

    private Context context = PolicyInteractionActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView1;
    @BindView(R.id.rv2)
    RecyclerView recyclerView2;
    @BindView(R.id.rv3)
    RecyclerView recyclerView3;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.view3)
    View view3;

    private PolicyInteractionAdapter adapter;
    private List<String> mList;

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

    @OnClick({R.id.rl_back, R.id.rl1, R.id.rl2, R.id.rl3})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl1:

                break;
            case R.id.rl2:

                break;
            case R.id.rl3:

                break;
        }
    }

}
