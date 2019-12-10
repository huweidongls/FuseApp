package com.guoyu.fuseapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.adapter.TyAdapter;
import com.guoyu.fuseapp.adapter.XgyyAdapter;
import com.guoyu.fuseapp.base.BaseFragment;
import com.guoyu.fuseapp.bean.SearchBean;
import com.guoyu.fuseapp.util.Logger;
import com.guoyu.fuseapp.util.ToastUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/10/15.
 */

public class FragmentSearch extends BaseFragment {

    public static FragmentSearch newInstance(String name, List<SearchBean.DataBean.ContentBean> content) {
        FragmentSearch newFragment = new FragmentSearch();
        Bundle bundle = new Bundle();
        bundle.putString("id", name);
        bundle.putSerializable("list", (Serializable) content);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private String name = "";
    private List<SearchBean.DataBean.ContentBean> content;
    private XgyyAdapter xgyyAdapter;
    private TyAdapter tyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);

        ButterKnife.bind(this, view);
        Bundle args = getArguments();
        if (args != null) {
            name = args.getString("id");
            content = (List<SearchBean.DataBean.ContentBean>) args.getSerializable("list");
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    private void initData() {
        if(name.equals("应用相关")){
            xgyyAdapter = new XgyyAdapter(content);
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(xgyyAdapter);
            //content = new ArrayList<>();
        }else {
            tyAdapter = new TyAdapter(content);
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(tyAdapter);
           // content = new ArrayList<>();
        }

    }

}
