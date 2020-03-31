package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppBookingBusinessqueryListMesBean;
import com.guoyu.fuseapp.page.MyYuyueDetailsActivity;

import java.util.List;

/**
 * Created by Administrator on 2020/1/8.
 */

public class MyYuyueAdapter extends RecyclerView.Adapter<MyYuyueAdapter.ViewHolder> {

    private Context context;
    private List<AppBookingBusinessqueryListMesBean.DataBean> data;

    public MyYuyueAdapter(List<AppBookingBusinessqueryListMesBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_myyuyue, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setText(data.get(position).getBusinessUserName());
        holder.tvBus.setText(data.get(position).getDetailsName());
        holder.tvTime.setText(data.get(position).getBusinessDate());
        int e = data.get(position).getEmploy();
        if(e == 0){
            holder.tvType.setText("待办");
        }else {
            holder.tvType.setText("已完结");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, MyYuyueDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvBus;
        private TextView tvTime;
        private TextView tvType;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvBus = itemView.findViewById(R.id.tv_bus);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvType = itemView.findViewById(R.id.tv_type);
        }
    }

}
