package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.ZhongjieListBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.page.ZhongjieDetailsActivity;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/10/23.
 */

public class ZhongjieListAdapter extends RecyclerView.Adapter<ZhongjieListAdapter.ViewHolder> {

    private Context context;
    private List<ZhongjieListBean.DataBean> data;
    private String title;
    private String funCode;

    public ZhongjieListAdapter(List<ZhongjieListBean.DataBean> data, String title, String funCode) {
        this.data = data;
        this.title = title;
        this.funCode = funCode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_zhongjie_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvSubTitle.setText(data.get(position).getContentShort());
        holder.tvSign.setText(data.get(position).getDepName());
        holder.tvTime.setText("发布时间："+data.get(position).getPublishDate());

        String img = data.get(position).getImgUrl();
        if(!StringUtils.isEmpty(img)){
            GlideUtils.into(context, NetUrl.BASE_URL+img.split(",")[0], holder.iv);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ZhongjieDetailsActivity.class);
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

        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvSign;
        private TextView tvTime;
        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubTitle = itemView.findViewById(R.id.tv_sub_title);
            tvSign = itemView.findViewById(R.id.tv_sign);
            tvTime = itemView.findViewById(R.id.tv_time);
            iv = itemView.findViewById(R.id.iv);
        }
    }

}
