package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.PolicyInteractionBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.PolicyInteractionDetailsActivity;

import java.util.List;

/**
 * Created by Administrator on 2020/1/9.
 */

public class PolicyInteractionAdapter extends RecyclerView.Adapter<PolicyInteractionAdapter.ViewHolder>{
    private Context context;
    private List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> data;
    public PolicyInteractionAdapter(List<PolicyInteractionBean.DataBean.GovernEnterInteractionBean.InteractionBean> data){
        this.data = data;
    }
    @Override
    public PolicyInteractionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_policy_interaction, parent, false);
        PolicyInteractionAdapter.ViewHolder holder = new PolicyInteractionAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PolicyInteractionAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(NetUrl.BASE_URL+data.get(position).getTitlePic()).into(holder.iv_img);
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_time.setText(data.get(position).getDepartmentName()+" "+data.get(position).getPublishDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("id",data.get(position).getId()+"");
                intent.setClass(context,PolicyInteractionDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView tv_title;
        private TextView tv_time;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
