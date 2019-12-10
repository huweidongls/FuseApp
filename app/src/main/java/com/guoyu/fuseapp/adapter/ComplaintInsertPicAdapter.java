package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.net.NetUrl;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class ComplaintInsertPicAdapter extends RecyclerView.Adapter<ComplaintInsertPicAdapter.ViewHolder>{
    private Context context;
    private List<String> data;
    private int type=0;
    private static final int TYPE_ADD = 1;
    private static final int TYPE_PIC = 2;
    private static final int MAX_SIZE = 9;

    private ClickListener listener;

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public ComplaintInsertPicAdapter(List<String> data,int types) {
        this.data = data;
        type=types;
}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_complaint_insert_pic, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (data.size() >= MAX_SIZE) {
            //最多9张
            holder.llAdd.setVisibility(View.GONE);
        } else {
            holder.rlPic.setVisibility(View.VISIBLE);
            holder.llAdd.setVisibility(View.VISIBLE);
        }
        if (getItemViewType(position) == TYPE_ADD&&data.size() == MAX_SIZE) {
            holder.llAdd.setVisibility(View.GONE);
            holder.rlPic.setVisibility(View.GONE);
        } else if(getItemViewType(position) == TYPE_ADD&&data.size()<MAX_SIZE){
            holder.llAdd.setVisibility(View.VISIBLE);
            holder.rlPic.setVisibility(View.GONE);
        } else if(getItemViewType(position) == TYPE_PIC){
            holder.llAdd.setVisibility(View.GONE);
            holder.rlPic.setVisibility(View.VISIBLE);
            Glide.with(context).load(data.get(position)).into(holder.ivPic);
           /* if (type==0){

            }else{
                Glide.with(context).load(NetUrl.BASE_URL+data.get(position)).into(holder.ivPic);
            }*/

        }
        holder.llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.addImg();
            }
        });
        holder.iv_del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.delImg(position,type);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_ADD;
        } else {
            return TYPE_PIC;
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout llAdd;
        private RelativeLayout rlPic;
        private ImageView ivPic;
        private ImageView iv_del1;
        public ViewHolder(View itemView) {
            super(itemView);
            llAdd = itemView.findViewById(R.id.ll_add);
            rlPic = itemView.findViewById(R.id.rl_pic);
            ivPic = itemView.findViewById(R.id.iv_pic);
            iv_del1 = itemView.findViewById(R.id.iv_del1);
        }
    }

    public interface ClickListener{
        void addImg();
        void delImg(int pos,int deltype);
    }
}
