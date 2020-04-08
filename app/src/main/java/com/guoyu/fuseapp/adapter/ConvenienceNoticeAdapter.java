package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.ConvenienceNoticeBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.ConvenienceNoticeDetailsActivity;
import com.guoyu.fuseapp.util.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/21.
 */

public class ConvenienceNoticeAdapter extends RecyclerView.Adapter<ConvenienceNoticeAdapter.ViewHolder> {

    private Context context;
    private List<ConvenienceNoticeBean.DataBean> data;
    private String title;
    private String funCode;

    public ConvenienceNoticeAdapter(List<ConvenienceNoticeBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_convenience_notice, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getTitle());
        GlideUtils.into(context, NetUrl.BASE_URL+data.get(position).getAppimg(), holder.iv);
        holder.tvTime.setText(data.get(position).getCreateDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ConvenienceNoticeDetailsActivity.class);
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

        private TextView tv;
        private ImageView iv;
        private TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }

}
