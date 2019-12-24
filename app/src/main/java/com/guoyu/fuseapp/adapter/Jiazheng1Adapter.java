package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.HouseServiceInfoItemAppqueryListAppBean;
import com.guoyu.fuseapp.bean.StyleInfoItemqueryListBean;

import java.util.List;

/**
 * Created by Administrator on 2019/12/23.
 */

public class Jiazheng1Adapter extends RecyclerView.Adapter<Jiazheng1Adapter.ViewHolder> {

    private Context context;
    private List<HouseServiceInfoItemAppqueryListAppBean.DataBean> data;
    private ClickListener listener;

    public Jiazheng1Adapter(List<HouseServiceInfoItemAppqueryListAppBean.DataBean> data, ClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_wenti1, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getTypeName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
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

    public interface ClickListener{
        void onItemClick(int pos);
    }

}
