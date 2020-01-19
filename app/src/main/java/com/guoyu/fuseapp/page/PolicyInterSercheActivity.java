package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.PolicyInteractionAdapter;
import com.guoyu.fuseapp.bean.PolicyInteractionBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PolicyInterSercheActivity extends AppCompatActivity {
    private Context context = PolicyInterSercheActivity.this;
    @BindView(R.id.et_titles)
    EditText etSearch;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    private PolicyInteractionAdapter adapter;
    private List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> mList;
    private InputMethodManager manager;//输入法管理器
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_inter_serche);
        ButterKnife.bind(PolicyInterSercheActivity.this);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        search();
    }
    private void search() {
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(etSearch.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    String search = etSearch.getText().toString();
                    if(!TextUtils.isEmpty(search)){
                        onSearch(search);
                    }
                }
                //记得返回false
                return false;
            }
        });
    }
    private void onSearch(String search) {
        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "0");
        map.put("pageSize", "0");
        map.put("title",search);
        ViseUtil.Get(context, NetUrl.AppGovernEnterInteractionqueryList, map, dialog,new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                PolicyInteractionBean bean = gson.fromJson(s,PolicyInteractionBean.class);
                mList = bean.getData().getGovernEnterInteraction().getInteraction();
                if(mList.size()>0){
                    empty_order_bloacks.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    adapter = new PolicyInteractionAdapter(mList);
                    LinearLayoutManager manager = new LinearLayoutManager(context);
                    manager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                }else{
                    empty_order_bloacks.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
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
