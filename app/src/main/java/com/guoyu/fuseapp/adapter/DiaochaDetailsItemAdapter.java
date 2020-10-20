package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppBusQuestionselectAllQuestionBean;

import java.util.List;

/**
 * Created by Administrator on 2020/10/15.
 */

public class DiaochaDetailsItemAdapter extends RecyclerView.Adapter<DiaochaDetailsItemAdapter.ViewHolder> {

    private Context context;
    private List<AppBusQuestionselectAllQuestionBean.DataBean.ListBean> data;

    public DiaochaDetailsItemAdapter(List<AppBusQuestionselectAllQuestionBean.DataBean.ListBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_diaocha_details_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(data.get(position).getIsSelect() == 0){
            holder.iv.setImageResource(R.mipmap.duihao_null);
        }else if(data.get(position).getIsSelect() == 1){
            holder.iv.setImageResource(R.mipmap.duihao_blue);
        }

        holder.tv.setText(data.get(position).getQuestionOption());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i<data.size(); i++){
                    data.get(i).setIsSelect(0);
                }
                data.get(position).setIsSelect(1);
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
