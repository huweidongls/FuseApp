package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.CommunitServiceNewsBean;
import com.guoyu.fuseapp.bean.GovernmentListBean;
import com.guoyu.fuseapp.page.CommunityBulletinContentActivity;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class CommunityBulletinAdapter extends RecyclerView.Adapter<CommunityBulletinAdapter.ViewHolder> {

    private Context context;
    private List<CommunitServiceNewsBean.DataBean> data;
    private String title;
    private String funCode;

    public CommunityBulletinAdapter(List<CommunitServiceNewsBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public CommunityBulletinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_community_bulletin, parent, false);
        CommunityBulletinAdapter.ViewHolder holder = new CommunityBulletinAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommunityBulletinAdapter.ViewHolder holder, final int position) {
        holder.tv_title.setText(data.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, CommunityBulletinContentActivity.class);
                intent.putExtra("id", data.get(position).getId() + "");
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

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

}
