package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.GovernmentServiceTypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public class GovernmentTypeAdapter extends RecyclerView.Adapter<GovernmentTypeAdapter.ViewHolder>{
    private Context context;
    private List<GovernmentServiceTypeBean.DataBean> data;
    private ClickListener listener;
    public GovernmentTypeAdapter(List<GovernmentServiceTypeBean.DataBean> data, ClickListener listener) {
        this.data = data;
        this.listener = listener;
    }
    @Override
    public GovernmentTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_government_type_list, parent, false);
        GovernmentTypeAdapter.ViewHolder holder = new GovernmentTypeAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GovernmentTypeAdapter.ViewHolder holder, final int position) {
        holder.tv_title.setText(data.get(position).getSubName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickType(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
    public interface ClickListener{
        void onClickType(int pos);
    }
}
