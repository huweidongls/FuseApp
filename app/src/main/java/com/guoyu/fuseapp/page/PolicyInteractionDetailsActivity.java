package com.guoyu.fuseapp.page;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.PolicyInteractionDetailsAdapter;
import com.guoyu.fuseapp.bean.PolicyInteractionDetailsBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.HtmlFromUtils;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;
import com.guoyu.fuseapp.util.WeiboDialogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PolicyInteractionDetailsActivity extends AppCompatActivity {
    private Context context = PolicyInteractionDetailsActivity.this;
    @BindView(R.id.et_comment)
    EditText et_comment;
    private List<PolicyInteractionDetailsBean.DataBean.CommentsBean> mList;
    private PolicyInteractionDetailsAdapter adapter;
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_time)
    TextView tv_time;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.empty_order_bloacks)
    RelativeLayout empty_order_bloacks;
    private String id= "";
    private int interId = 0;
    private Dialog dialog;
    private InputMethodManager manager;//输入法管理器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_interaction_details);
        ButterKnife.bind(PolicyInteractionDetailsActivity.this);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        id = getIntent().getStringExtra("id");
        initInfo();
        search();
    }
    private void search() {
        et_comment.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(et_comment.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    String search = et_comment.getText().toString();
                    if(!TextUtils.isEmpty(search)){
                        submit(search);
                    }
                }
                //记得返回false
                return false;
            }
        });
    }

    private void submit(String search) {
        dialog = WeiboDialogUtils.createLoadingDialog(context,"请等待...");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("commentUserId", SpUtils.getUserId(context));
        map.put("commentContent",search);
        map.put("interId",interId+"");
        ViseUtil.Post(context, NetUrl.AppGovernEnterInteractiontoUpdate, map,dialog,new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                ToastUtil.showShort(context,"评论成功!");
                Map<String,String> map = new LinkedHashMap<>();
                map.put("id",id);
                ViseUtil.Get(context, NetUrl.AppGovernEnterInteractiongetOne, map, new ViseUtil.ViseListener() {
                            @Override
                            public void onReturn(String s) {
                                Gson gson = new Gson();
                                PolicyInteractionDetailsBean bean = gson.fromJson(s,PolicyInteractionDetailsBean.class);
                                mList = bean.getData().getComments();
                                et_comment.setText(null);
                                if(mList.size()>0){
                                    empty_order_bloacks.setVisibility(View.GONE);
                                    recyclerView.setVisibility(View.VISIBLE);
                                    adapter = new PolicyInteractionDetailsAdapter(mList);
                                    LinearLayoutManager manager = new LinearLayoutManager(context){
                                        @Override
                                        public boolean canScrollVertically() {
                                            return false;
                                        }
                                    };
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
        });
    }

    private void initInfo() {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("id",id);
        ViseUtil.Get(context, NetUrl.AppGovernEnterInteractiongetOne, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                PolicyInteractionDetailsBean bean = gson.fromJson(s,PolicyInteractionDetailsBean.class);
                tv_title.setText(bean.getData().getInteraction().getTitle());
                tv_time.setText(bean.getData().getInteraction().getDepartmentName()+" "+bean.getData().getInteraction().getPublishDate());//tv_content
                HtmlFromUtils.setTextFromHtml(PolicyInteractionDetailsActivity.this, tv_content, bean.getData().getInteraction().getContent());
                interId = bean.getData().getInteraction().getId();
                mList = bean.getData().getComments();
                if(mList.size()>0){
                    empty_order_bloacks.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    adapter = new PolicyInteractionDetailsAdapter(mList);
                    LinearLayoutManager manager = new LinearLayoutManager(context){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
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
