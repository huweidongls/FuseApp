package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.CreditList1Bean;
import com.guoyu.fuseapp.page.CreditDetails1Activity;

import java.util.List;

/**
 * Created by Administrator on 2020/8/13.
 */

public class CreditList1Adapter extends RecyclerView.Adapter<CreditList1Adapter.ViewHolder> {

    private Context context;
    private List<CreditList1Bean.RowsBean> data;

    public CreditList1Adapter(List<CreditList1Bean.RowsBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_credit_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setText(data.get(position).getXK_XDR_MC());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, CreditDetails1Activity.class);
                intent.putExtra("bean", data.get(position));
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

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

}
