package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.Fragment3Bean;
import com.guoyu.fuseapp.imagepreview.Consts;
import com.guoyu.fuseapp.imagepreview.ImagePreviewActivity;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class UrbaneleganceAdapter extends RecyclerView.Adapter<UrbaneleganceAdapter.ViewHolder> {

    private Context context;
    private List<Fragment3Bean.DataBean> data;

    public UrbaneleganceAdapter(List<Fragment3Bean.DataBean> data) {
        this.data = data;
    }

    @Override
    public UrbaneleganceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_urban_elegance, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UrbaneleganceAdapter.ViewHolder holder, final int position) {
        if(data.get(position).getContentPics()!=null){
            final String[] pics = data.get(position).getContentPics().split(",");
            if(pics.length>=0&&pics.length<2){
                holder.ivTitle.setVisibility(View.VISIBLE);
                holder.rv.setVisibility(View.GONE);
                GlideUtils.into(context, NetUrl.BASE_URL + pics[0], holder.ivTitle);
                holder.ivTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<String> urlList = new ArrayList<>();
                        urlList.add(NetUrl.BASE_URL + pics[0]);
                        Intent intent = new Intent(context, ImagePreviewActivity.class);
                        intent.putExtra("imageList", (Serializable) urlList);
                        intent.putExtra(Consts.START_ITEM_POSITION, 0);
                        intent.putExtra(Consts.START_IAMGE_POSITION, 0);
                        context.startActivity(intent);
                    }
                });
            }else {
                holder.ivTitle.setVisibility(View.GONE);
                holder.rv.setVisibility(View.VISIBLE);
                FengcaiItemAdapter itemAdapter = new FengcaiItemAdapter(pics);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                holder.rv.setLayoutManager(manager);
                holder.rv.setAdapter(itemAdapter);
            }
        }
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvContent.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivTitle;
        private TextView tvTitle;
        private RecyclerView rv;
        private TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTitle = itemView.findViewById(R.id.iv_title);
            tvTitle = itemView.findViewById(R.id.tv_title);
            rv = itemView.findViewById(R.id.rv);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

}
