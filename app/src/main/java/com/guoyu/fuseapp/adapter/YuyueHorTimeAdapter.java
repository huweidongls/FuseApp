package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2020/7/20.
 */

public class YuyueHorTimeAdapter extends RecyclerView.Adapter<YuyueHorTimeAdapter.ViewHolder> {

    private Context context;
    private List<String> data;
    private int select = 0;
    private ClickListener listener;

    public YuyueHorTimeAdapter(ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_yuyue_hor_time, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if(position == select){
            holder.rl.setBackgroundResource(R.color.theme);
            holder.tvWeek.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvDay.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.rl.setBackgroundResource(R.color.white_ffffff);
            holder.tvWeek.setTextColor(Color.parseColor("#5F5F5F"));
            holder.tvDay.setTextColor(Color.parseColor("#5F5F5F"));
        }
        int day1 = StringUtils.getOldDay(position+1);
        final int week1 = StringUtils.getOldWeek(position+1);
        if(week1 == 1||week1 == 7){
            holder.rl.setBackgroundResource(R.color.line);
            holder.tvWeek.setTextColor(Color.parseColor("#5F5F5F"));
            holder.tvDay.setTextColor(Color.parseColor("#5F5F5F"));
        }
        holder.tvWeek.setText(getWeek(week1));
        holder.tvDay.setText(formatTimeUnit(day1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(week1 == 1||week1 == 7){

                }else {
                    select = position;
                    notifyDataSetChanged();
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 14;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvWeek;
        private TextView tvDay;
        private RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWeek = itemView.findViewById(R.id.tv_week1);
            tvDay = itemView.findViewById(R.id.tv_day1);
            rl = itemView.findViewById(R.id.rl1);
        }
    }

    private String getWeek(int week){
        String w = "";
        switch (week){
            case 1:
                w = "周日";
                break;
            case 2:
                w = "周一";
                break;
            case 3:
                w = "周二";
                break;
            case 4:
                w = "周三";
                break;
            case 5:
                w = "周四";
                break;
            case 6:
                w = "周五";
                break;
            case 7:
                w = "周六";
                break;
        }
        return w;
    }

    /**
     * 将“0-9”转换为“00-09”
     */
    private String formatTimeUnit(int unit) {
        return unit < 10 ? "0" + String.valueOf(unit) : String.valueOf(unit);
    }

    public interface ClickListener{
        void onItemClick(int pos);
    }

}
