package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.page.WeizhangDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/20.
 */

public class WeizhangListAdapter extends RecyclerView.Adapter<WeizhangListAdapter.ViewHolder> {

    private Context context;
    private List<ArrayList<String>> data;

    public WeizhangListAdapter(List<ArrayList<String>> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_weizhang_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvWfxw.setText(data.get(position).get(4));
        holder.tvAddress.setText(data.get(position).get(3));
        holder.tvTime.setText(data.get(position).get(1).split("\\.")[0]);
        holder.tvMoney.setText("罚款"+data.get(position).get(5)+"元");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, WeizhangDetailsActivity.class);
                intent.putStringArrayListExtra("list", data.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvWfxw;
        private TextView tvAddress;
        private TextView tvTime;
        private TextView tvMoney;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWfxw = itemView.findViewById(R.id.tv_wfxw);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvMoney = itemView.findViewById(R.id.tv_money);
        }
    }

}
