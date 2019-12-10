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
import com.guoyu.fuseapp.bean.JaizhengListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.JiazhengDetailsActivity;
import com.guoyu.fuseapp.util.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/19.
 */

public class JaizhengListAdapter extends RecyclerView.Adapter<JaizhengListAdapter.ViewHolder> {

    private Context context;
    private List<JaizhengListBean.DataBean> data;
    private String title;
    private String funCode;

    public JaizhengListAdapter(List<JaizhengListBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_jiazheng_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(data.get(position).getTopPic()!=null){
            String[] pics = data.get(position).getTopPic().split(",");
            if(pics.length>0){
                GlideUtils.into(context, NetUrl.BASE_URL+pics[0], holder.iv);
            }
        }
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvContent.setText(data.get(position).getContentTop());
        holder.tvPrice.setText("¥"+data.get(position).getMoney()+"元");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, JiazhengDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId()+"");
                intent.putExtra("title", title);
                intent.putExtra("funcode", funCode);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tvTitle;
        private TextView tvContent;
        private TextView tvPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }

}
