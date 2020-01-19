package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.PolicyInteractionDetailsBean;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.StringUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/9.
 */

public class PolicyInteractionDetailsAdapter extends RecyclerView.Adapter<PolicyInteractionDetailsAdapter.ViewHolder>{
    private Context context;
    private List<PolicyInteractionDetailsBean.DataBean.CommentsBean> data;
    public PolicyInteractionDetailsAdapter(List<PolicyInteractionDetailsBean.DataBean.CommentsBean> data){
        this.data = data;
    }
    @Override
    public PolicyInteractionDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_policy_interaction_details,parent,false);
        PolicyInteractionDetailsAdapter.ViewHolder holder = new PolicyInteractionDetailsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final PolicyInteractionDetailsAdapter.ViewHolder holder, final int position) {
        holder.tv_time.setText(StringUtils.friendly_time(data.get(position).getCreateDate()));
        holder.tv_tel.setText(data.get(position).getCommentUserName());
        holder.tv_content.setText(data.get(position).getCommentContent());
        holder.tv_looknum.setText(data.get(position).getLikeNum()+"");
        Glide.with(context).load(NetUrl.BASE_URL+data.get(position).getCommentUserPic()).into(holder.iv_img);
        holder.iv_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(position).getIsZan() == 0){
                    Map<String,String> map = new LinkedHashMap<>();
                    map.put("likeNumId",data.get(position).getId()+"");
                    ViseUtil.Post(context, NetUrl.AppGovernEnterInteractionlikeNum, map, new ViseUtil.ViseListener() {
                        @Override
                        public void onReturn(String s) {
                            data.get(position).setLikeNum(data.get(position).getLikeNum()+1);
                            data.get(position).setIsZan(1);
                            Glide.with(context).load(R.mipmap.zan).into(holder.iv_good);
                            ToastUtil.showShort(context,"点赞成功!");
                            notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_img;
        private TextView tv_tel;
        private TextView tv_time;
        private TextView tv_content;
        private TextView tv_looknum;
        private ImageView iv_good;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_tel = itemView.findViewById(R.id.tv_tel);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_looknum = itemView.findViewById(R.id.tv_looknum);
            iv_good = itemView.findViewById(R.id.iv_good);
        }
    }
}
