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
import com.guoyu.fuseapp.bean.IndexGongnengBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.LoginActivity;
import com.guoyu.fuseapp.page.ModuleWebViewActivity;
import com.guoyu.fuseapp.page.MoreActivity;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class IndexGongnengAdapter extends RecyclerView.Adapter<IndexGongnengAdapter.ViewHolder> {

    private Context context;
    private List<IndexGongnengBean.DataBean> data;
    private int max;

    public IndexGongnengAdapter(List<IndexGongnengBean.DataBean> data) {
        this.data = data;
        max = data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_index_gongneng, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(position == max){
            holder.ll.setVisibility(View.GONE);
            holder.llMore.setVisibility(View.VISIBLE);
        }else {
            holder.ll.setVisibility(View.VISIBLE);
            holder.llMore.setVisibility(View.GONE);
            GlideUtils.into(context, NetUrl.BASE_URL+data.get(position).getLogoPic(), holder.iv);
            holder.tv.setText(data.get(position).getFunName());
        }
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
                        intent.putExtra("funcode", data.get(position).getFunCode());
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
                        intent.putExtra("funcode", data.get(position).getFunCode());
                        intent.putExtra("title", data.get(position).getFunName());
                        intent.putExtra("urltype", data.get(position).getUrlType()+"");
                        intent.putExtra("url", data.get(position).getUrl());
                        context.startActivity(intent);
                    }
                }
            }
        });
        holder.llMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, MoreActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size()+1;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;
        private LinearLayout ll;
        private LinearLayout llMore;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
            llMore = itemView.findViewById(R.id.ll_more);
        }
    }

}
