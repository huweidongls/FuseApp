package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.GovernmentListBean;
import com.guoyu.fuseapp.page.CommunityBulletinContentActivity;
import com.guoyu.fuseapp.page.GobernmentContentActivity;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public class GovernmentListAdapter extends RecyclerView.Adapter<GovernmentListAdapter.ViewHolder> {

    private Context context;
    private List<GovernmentListBean.DataBean> data;
    private String title;
    private String funCode;

    public GovernmentListAdapter(List<GovernmentListBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public GovernmentListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_government_list, parent, false);
        GovernmentListAdapter.ViewHolder holder = new GovernmentListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GovernmentListAdapter.ViewHolder holder, final int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_tag.setText("【" + data.get(position).getGovTypeName() + "】");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,GobernmentContentActivity.class);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_tag;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_tag = itemView.findViewById(R.id.tv_tag);
        }
    }
}
