package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppAppointmentqueryListBean;
import com.guoyu.fuseapp.page.YuyueTimeActivity;
import com.guoyu.fuseapp.page.YuyueYewuActivity;

import java.util.List;

/**
 * Created by Administrator on 2020/1/8.
 */

public class YuyueBumenAdapter extends RecyclerView.Adapter<YuyueBumenAdapter.ViewHolder> {

    private Context context;
    private List<AppAppointmentqueryListBean.DataBean> data;

    public YuyueBumenAdapter(List<AppAppointmentqueryListBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_yuyuebumen, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getAreaName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(context, YuyueYewuActivity.class);
//                intent.putExtra("id", data.get(position).getId()+"");
//                context.startActivity(intent);
                Intent intent = new Intent();
                intent.setClass(context, YuyueTimeActivity.class);
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

        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
