package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppAppointmentgetOneByTimeBean;
import com.guoyu.fuseapp.page.YuyueSureActivity;
import com.guoyu.fuseapp.util.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2020/1/17.
 */

public class YuyueTimeAdapter extends RecyclerView.Adapter<YuyueTimeAdapter.ViewHolder> {

    private Context context;
    private List<AppAppointmentgetOneByTimeBean.DataBean.ListBean> data;
    private String content;

    public YuyueTimeAdapter(List<AppAppointmentgetOneByTimeBean.DataBean.ListBean> data, String content) {
        this.data = data;
        this.content = content;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_yuyue_time, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.tvTime.setText(data.get(position).getOrderStartTime()+"-"+data.get(position).getOrderEndTime());
        holder.tvTime.setText(data.get(position).getTimeSlot());
        final int count = data.get(position).getNum();
        if(count>0){
            holder.tvYuyue.setTextColor(Color.parseColor("#1E8EE4"));
            holder.tvYuyue.setBackgroundResource(R.drawable.bg_d62424_4dp_bord);
            holder.tvYuyue.setText("预约");
        }else {
            holder.tvYuyue.setTextColor(Color.parseColor("#5F5F5F"));
            holder.tvYuyue.setBackgroundResource(R.drawable.bg_5f5f5f_4dp_bord);
            holder.tvYuyue.setText("已约满");
        }
        holder.tvKeyong.setText("可用："+count);
        holder.tvYuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    Intent intent = new Intent();
                    intent.setClass(context, YuyueSureActivity.class);
                    intent.putExtra("bean", data.get(position));
                    intent.putExtra("content", content);
                    context.startActivity(intent);
                }else{
                    ToastUtil.showShort(context, "已约满");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTime;
        private TextView tvKeyong;
        private TextView tvYuyue;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvKeyong = itemView.findViewById(R.id.tv_keyong);
            tvYuyue = itemView.findViewById(R.id.tv_yuyue);
        }
    }

}
