package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppAppointmentgetByAppointmentAppBean;
import com.guoyu.fuseapp.dialog.DialogCustom;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.MyYuyueDetailsActivity;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/8.
 */

public class MyYuyueAdapter extends RecyclerView.Adapter<MyYuyueAdapter.ViewHolder> {

    private Context context;
    private List<AppAppointmentgetByAppointmentAppBean.DataBean> data;

    public MyYuyueAdapter(List<AppAppointmentgetByAppointmentAppBean.DataBean> data) {
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
        holder.tvName.setText(data.get(position).getUsername());
        holder.tvBus.setText(data.get(position).getAreaName());
        holder.tvTime.setText(data.get(position).getNyrTime());
        holder.tvTime1.setText(data.get(position).getTimeSlot());
//        int e = data.get(position).getEmploy();
//        if(e == 0){
//            holder.tvType.setText("待办");
//        }else {
//            holder.tvType.setText("已完结");
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, MyYuyueDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId()+"");
                context.startActivity(intent);
            }
        });
        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCustom dialogCustom = new DialogCustom(context, "是否取消预约", new DialogCustom.OnYesListener() {
                    @Override
                    public void onYes() {
                        Map<String, String> map = new LinkedHashMap<>();
                        map.put("id", data.get(position).getId()+"");
                        ViseUtil.Get(context, NetUrl.AppAppointmentdeleteById, map, new ViseUtil.ViseListener() {
                            @Override
                            public void onReturn(String s) {
                                ToastUtil.showShort(context, "取消成功");
                                data.remove(position);
                                notifyDataSetChanged();
                            }
                        });
                    }
                });
                dialogCustom.show();
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
        private TextView tvTime1;
        private Button btnCancel;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvBus = itemView.findViewById(R.id.tv_bus);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvType = itemView.findViewById(R.id.tv_type);
            tvTime1 = itemView.findViewById(R.id.tv_time1);
            btnCancel = itemView.findViewById(R.id.btn_cancel);
        }
    }

}
