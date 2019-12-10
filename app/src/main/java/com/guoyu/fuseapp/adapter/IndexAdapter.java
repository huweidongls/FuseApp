package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.IndexBean;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.ModuleWebViewActivity;
import com.guoyu.fuseapp.util.SpUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ViewHolder> {

    private Context context;
    private List<IndexBean.DataBean> data;

    public IndexAdapter(List<IndexBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_index, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(data.get(position).getUnregSee() == 0){
                    if(SpUtils.getUserId(context).equals("0")){
                        intent.setClass(context, LoginActivity.class);
                        context.startActivity(intent);
                    }else if(data.get(position).getModularUrl() == null){
                        try {
                            intent.setClass(context, Class.forName(data.get(position).getAndroidModularUrl()));
                            intent.putExtra("id", data.get(position).getId()+"");
                            intent.putExtra("title", data.get(position).getFunName());
                            intent.putExtra("funcode", data.get(position).getFunCode());
                            context.startActivity(intent);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }else {
                        intent.setClass(context, ModuleWebViewActivity.class);
                        intent.putExtra("title", data.get(position).getFunName());
                        intent.putExtra("urltype", data.get(position).getUrlType()+"");
                        intent.putExtra("url", data.get(position).getModularUrl());
                        intent.putExtra("id", data.get(position).getId()+"");
                        context.startActivity(intent);
                    }
                }else {
                    if(data.get(position).getModularUrl() == null){
                        try {
                            intent.setClass(context, Class.forName(data.get(position).getAndroidModularUrl()));
                            intent.putExtra("id", data.get(position).getId()+"");
                            intent.putExtra("title", data.get(position).getFunName());
                            intent.putExtra("funcode", data.get(position).getFunCode());
                            context.startActivity(intent);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }else {
                        intent.setClass(context, ModuleWebViewActivity.class);
                        intent.putExtra("title", data.get(position).getFunName());
                        intent.putExtra("urltype", data.get(position).getUrlType()+"");
                        intent.putExtra("url", data.get(position).getModularUrl());
                        intent.putExtra("id", data.get(position).getId()+"");
                        context.startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
