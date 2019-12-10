package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.CommunitServiceNewsBean;
import com.guoyu.fuseapp.bean.StylisticServiceListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.ComplaintDetailsActivity;
import com.guoyu.fuseapp.page.StylisticServiceContentActivity;
import com.guoyu.fuseapp.util.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/22.
 */

public class StylisticServiceListAdapter extends RecyclerView.Adapter<StylisticServiceListAdapter.ViewHolder> {

    private Context context;
    private List<StylisticServiceListBean.DataBean.ListsBean> data;
    private String title;
    private String funCode;

    public StylisticServiceListAdapter(List<StylisticServiceListBean.DataBean.ListsBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public StylisticServiceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_stylistic_service_list, parent, false);
        StylisticServiceListAdapter.ViewHolder holder = new StylisticServiceListAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StylisticServiceListAdapter.ViewHolder holder, final int position) {
        if(data.get(position).getTopPic()!=null){
            String[] pics = data.get(position).getTopPic().split(",");
            if(pics.length>0){
                GlideUtils.into(context, NetUrl.BASE_URL + pics[0], holder.iv_zhu);
            }
        }
        holder.textView.setText("活动地点：" + data.get(position).getActivityPlace());
        holder.textViews.setText("时间：" + data.get(position).getActivityTime());
        holder.textView2.setText(data.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, StylisticServiceContentActivity.class);
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
        private ImageView iv_zhu;
        private TextView textView2;
        private TextView textView;
        private TextView textViews;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_zhu = itemView.findViewById(R.id.iv_zhu);
            textView2 = itemView.findViewById(R.id.textView2);
            textView = itemView.findViewById(R.id.textView);
            textViews = itemView.findViewById(R.id.textViews);
        }
    }
}
