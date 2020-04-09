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
import com.guoyu.fuseapp.bean.ConsultationTypeBean;
import com.guoyu.fuseapp.page.ComplaintDetailsActivity;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class FragmentConsultationTypeAdapter extends RecyclerView.Adapter<FragmentConsultationTypeAdapter.ViewHolder> {

    private Context context;
    private List<ConsultationTypeBean.DataBean> data;

    public FragmentConsultationTypeAdapter(List<ConsultationTypeBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public FragmentConsultationTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_consultation_type, parent, false);
        FragmentConsultationTypeAdapter.ViewHolder holder = new FragmentConsultationTypeAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FragmentConsultationTypeAdapter.ViewHolder holder, final int position) {
        holder.tv_name.setText(data.get(position).getTitle());
        if (data.get(position).getStatusid() == 1) {//待反馈
            holder.tvRight.setVisibility(View.GONE);
            Glide.with(context).load(R.mipmap.icon0123x).into(holder.iv_img);
        }
        if (data.get(position).getStatusid() == 2) {//已反馈
            holder.tvRight.setVisibility(View.VISIBLE);
            Glide.with(context).load(R.mipmap.icon0113x).into(holder.iv_img);
            holder.feeMemo.setText(data.get(position).getFeeMemo());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ComplaintDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId() + "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView tv_name;
        private TextView feeMemo;
        private TextView tvRight;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_name = itemView.findViewById(R.id.tv_name);
            feeMemo = itemView.findViewById(R.id.feeMemo);
            tvRight = itemView.findViewById(R.id.tv_right);
        }
    }
}
