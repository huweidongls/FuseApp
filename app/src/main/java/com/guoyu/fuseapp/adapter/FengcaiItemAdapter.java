package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.imagepreview.Consts;
import com.guoyu.fuseapp.imagepreview.ImagePreviewActivity;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/31.
 */

public class FengcaiItemAdapter extends RecyclerView.Adapter<FengcaiItemAdapter.ViewHolder> {

    private Context context;
    private String[] data;

    public FengcaiItemAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_fengcai_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        GlideUtils.into(context, NetUrl.BASE_URL+data[position], holder.iv);
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> urlList = new ArrayList<>();
                for (String s : data){
                    urlList.add(NetUrl.BASE_URL+s);
                }
                Intent intent = new Intent(context, ImagePreviewActivity.class);
                intent.putExtra("imageList", (Serializable) urlList);
                intent.putExtra(Consts.START_ITEM_POSITION, position);
                intent.putExtra(Consts.START_IAMGE_POSITION, position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }

}
