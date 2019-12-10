package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.SafeListBean;
import com.guoyu.fuseapp.page.SafeDetailsActivity;

import java.util.List;

/**
 * Created by Administrator on 2019/10/19.
 */

public class SafeListAdapter extends RecyclerView.Adapter<SafeListAdapter.ViewHolder> {

    private Context context;
    private List<SafeListBean.DataBean> data;
    private String title;
    private String funCode;

    public SafeListAdapter(List<SafeListBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_safe_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv.setText(data.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, SafeDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId()+"");
                intent.putExtra("title", title);
                intent.putExtra("funcode", funCode);
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
