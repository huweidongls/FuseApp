package com.guoyu.fuseapp.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.ShequListAdapter;
import com.guoyu.fuseapp.base.BaseActivity;
import com.guoyu.fuseapp.bean.XiaoquListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhouzhuo.zzletterssidebar.ZzLetterSideBar;
import me.zhouzhuo.zzletterssidebar.interf.OnLetterTouchListener;

public class ShequListActivity extends BaseActivity {

    private Context context = ShequListActivity.this;

    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.et_search)
    EditText etSearch;

    private ShequListAdapter adapter;
    private List<XiaoquListBean.DataBean> mList;
    private ZzLetterSideBar sideBar;
    private TextView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shequ_list);

        ButterKnife.bind(ShequListActivity.this);
        initData();

    }

    private void initData() {

        sideBar = (ZzLetterSideBar) findViewById(R.id.sidebar);
        dialog = (TextView) findViewById(R.id.tv_dialog);

        ViseUtil.Get(context, NetUrl.AppCommunityServiceInfofindArea, null, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                XiaoquListBean bean = gson.fromJson(s, XiaoquListBean.class);
                mList = bean.getData();
                adapter = new ShequListAdapter(context, mList);
                listView.setAdapter(adapter);
                //设置右侧触摸监听
                sideBar.setLetterTouchListener(listView, adapter, dialog, new OnLetterTouchListener() {
                    @Override
                    public void onLetterTouch(String letter, int position) {
                    }

                    @Override
                    public void onActionUp() {
                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent();
                        intent.putExtra("id", mList.get(position).getId()+"");
                        intent.putExtra("name", mList.get(position).getCommName());
                        setResult(1002, intent);
                        ShequListActivity.this.finish();
                    }
                });
//                etSearch.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence sequence, int i, int i1, int i2) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
//                        adapter.getFilter().filter(sequence.toString());
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable editable) {
//
//                    }
//                });
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
