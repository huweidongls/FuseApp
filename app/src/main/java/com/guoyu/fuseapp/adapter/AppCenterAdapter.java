package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppCenterqueryListBean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class AppCenterAdapter extends RecyclerView.Adapter<AppCenterAdapter.ViewHolder> {

    private Context context;
    private List<AppCenterqueryListBean.DataBean> data;

    public AppCenterAdapter(List<AppCenterqueryListBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_more_gongneng, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getTypeName());
        List<AppCenterqueryListBean.DataBean.AppCentersBean> list = data.get(position).getAppCenters();
        AppCenterItemAdapter itemAdapter = new AppCenterItemAdapter(list);
        GridLayoutManager manager = new GridLayoutManager(context, 4);
        holder.rv.setLayoutManager(manager);
        holder.rv.setAdapter(itemAdapter);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rv = itemView.findViewById(R.id.rv);
        }
    }

}
