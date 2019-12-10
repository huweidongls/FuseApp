package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.MoreGongnengBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.ModuleWebViewActivity;
import com.guoyu.fuseapp.util.SpUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/11.
 */

public class MoreGongnengItemAdapter extends RecyclerView.Adapter<MoreGongnengItemAdapter.ViewHolder> {

    private Context context;
    private List<MoreGongnengBean.DataBean.ListBean> data;

    public MoreGongnengItemAdapter(List<MoreGongnengBean.DataBean.ListBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_more_gongneng_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(NetUrl.BASE_URL+data.get(position).getLogoPic()).into(holder.iv);
        holder.tv.setText(data.get(position).getFunName());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(data.get(position).getUnregSee() == 0){
                    if(SpUtils.getUserId(context).equals("0")){
                        intent.setClass(context, LoginActivity.class);
                        context.startActivity(intent);
                    }else if(data.get(position).getUrl() == null){
                        try {
                            intent.setClass(context, Class.forName(data.get(position).getAndroidUrl()));
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
                        intent.putExtra("url", data.get(position).getUrl());
                        context.startActivity(intent);
                    }
                }else {
                    if(data.get(position).getUrl() == null){
                        try {
                            intent.setClass(context, Class.forName(data.get(position).getAndroidUrl()));
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
                        intent.putExtra("url", data.get(position).getUrl());
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

        private ImageView iv;
        private TextView tv;
        private LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }

}
