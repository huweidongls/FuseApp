package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.DiaochaDetailsAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.AppBusQuestionselectAllQuestionBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiaochawenjuanDetailsActivity extends BaseActivity {

    private Context context = DiaochawenjuanDetailsActivity.this;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private DiaochaDetailsAdapter adapter;
    private List<AppBusQuestionselectAllQuestionBean.DataBean> mList;

    private String id = "";
    private String sm = "";
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaochawenjuan_details);

        id = getIntent().getStringExtra("id");
        sm = getIntent().getStringExtra("sm");
        ButterKnife.bind(DiaochawenjuanDetailsActivity.this);
        initData();

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("questionClassifyId", id);
        ViseUtil.Post(context, NetUrl.AppBusQuestionselectAllQuestion, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppBusQuestionselectAllQuestionBean bean = gson.fromJson(s, AppBusQuestionselectAllQuestionBean.class);
                mList = bean.getData();
                adapter = new DiaochaDetailsAdapter(mList);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.rl_submit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_submit:
                submit();
                break;
        }
    }

    private void submit() {

        dialog = WeiboDialogUtils.createLoadingDialog(context, "请等待...");
        List<String> s = new ArrayList<>();
        for(int i = 0; i<mList.size(); i++){
            for(int j = 0; j<mList.get(i).getList().size(); j++){
                if(mList.get(i).getList().get(j).getIsSelect() == 1){
                    s.add(mList.get(i).getList().get(j).getId()+"");
                }
            }
        }
        String ss = "";
        if(s.size()>0){
            for(int i = 0; i<s.size(); i++){
                if(i == s.size()-1){
                    ss = ss + s.get(i);
                }else {
                    ss = ss + s.get(i) + ",";
                }
            }
        }
        Logger.e("123123", ss);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("ids", ss);
        if(sm.equals("1")){
            map.put("userId", SpUtils.getUserId(context));
        }
        ViseUtil.Post(context, NetUrl.AppBusQuestionsubmitAllAnswer, map, dialog, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                ToastUtil.showShort(context, "提交成功");
                finish();
            }
        });

    }

}
