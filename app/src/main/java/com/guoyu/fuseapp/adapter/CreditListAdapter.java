package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.SyscreditBean;
import com.guoyu.fuseapp.page.CreditDetailsActivity;

import java.util.List;

/**
 * Created by Administrator on 2020/8/12.
 */

public class CreditListAdapter extends RecyclerView.Adapter<CreditListAdapter.ViewHolder> {

    private Context context;
    private List<SyscreditBean.RowsBean> data;

    public CreditListAdapter(List<SyscreditBean.RowsBean> data) {
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
        holder.tvName.setText(data.get(position).getCOMP_NAME());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, CreditDetailsActivity.class);
                intent.putExtra("title", "信用查询");
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
