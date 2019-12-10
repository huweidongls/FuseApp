package com.guoyu.fuseapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.WeiguanListBean;
import com.guoyu.fuseapp.dialog.DialogCustom;
import com.guoyu.fuseapp.imagepreview.Consts;
import com.guoyu.fuseapp.imagepreview.ImagePreviewActivity;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.nine.NineGridTestLayout;
import com.guoyu.fuseapp.page.CityMicroUpdateActivity;
import com.guoyu.fuseapp.page.ComplaintInsertActivity;
import com.guoyu.fuseapp.util.GlideUtils;
import com.guoyu.fuseapp.util.ToastUtil;
import com.guoyu.fuseapp.util.ViseUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/9.
 */

public class WeiguanAdapter extends RecyclerView.Adapter<WeiguanAdapter.ViewHolder> {

    private Context context;
    private List<WeiguanListBean.DataBean> data;
    private String id;

    public WeiguanAdapter(List<WeiguanListBean.DataBean> data, String id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_weiguan, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (data.get(position).getNikePic() != null) {
            String[] pics = data.get(position).getNikePic().split(",");
            if (pics.length > 0) {
                GlideUtils.into(context, NetUrl.BASE_URL + pics[0], holder.iv_header);
            }
        }
        holder.tv_user.setText(data.get(position).getNickName());
        if(id.equals("0")){
            holder.tv_addtime.setText(data.get(position).getPublishDate());
        }else if(id.equals("1")){
            holder.tv_addtime.setText(data.get(position).getPublishDate());
        }else if(id.equals("2")){
            holder.tv_addtime.setText(data.get(position).getCreateDate());
        }
        holder.tv_content.setText(data.get(position).getContent());
        switch (data.get(position).getStatusid()) {
            case 1:
                holder.tv_status.setText("待审核");
                holder.tv_status.setBackgroundResource(R.drawable.bg_ffbc1a_9dp);
                holder.ll_set.setVisibility(View.VISIBLE);
                holder.ll_text.setVisibility(View.GONE);
                break;
            case 2:
                holder.tv_status.setText("已审核");
                holder.tv_status.setBackgroundResource(R.drawable.bg_bbbbbb_9dp);
                holder.ll_text.setVisibility(View.GONE);
                holder.ll_set.setVisibility(View.GONE);
                break;
            case 3:
                holder.tv_status.setText("已反馈");
                holder.tv_status.setBackgroundResource(R.drawable.bg_bbbbbb_9dp);
                holder.ll_text.setVisibility(View.VISIBLE);
                holder.ll_set.setVisibility(View.GONE);
                holder.tv_fff.setText("【反馈意见】" + data.get(position).getFeeMemo());
                break;
            case 4:
                holder.tv_status.setText("已拒绝");
                holder.tv_status.setBackgroundResource(R.drawable.bg_bbbbbb_9dp);
                holder.ll_text.setVisibility(View.GONE);
                holder.ll_set.setVisibility(View.GONE);
                break;
        }
        holder.ll_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCustom dialog = new DialogCustom(context, "确定删除吗?", new DialogCustom.OnYesListener() {
                    @Override
                    public void onYes() {
                        Map<String, String> map = new LinkedHashMap<>();
                        map.put("id", data.get(position).getId() + "");
                        ViseUtil.Get(context, NetUrl.AppMiniCityInfotoDelete, map, new ViseUtil.ViseListener() {
                            @Override
                            public void onReturn(String s) {
                                ToastUtil.showShort(context, "删除成功!");
                                data.remove(position);
                                notifyDataSetChanged();
                            }
                        });
                    }
                });
                dialog.show();
            }
        });
        holder.ll_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("id", data.get(position).getId() + "");
                intent.setClass(context, CityMicroUpdateActivity.class);
                context.startActivity(intent);
            }
        });
        String[] s = data.get(position).getContentPic().split(",");
        final List<String> list = new ArrayList<>();
        for (String ss : s) {
            list.add(NetUrl.BASE_URL + ss);
        }
        if (list.size() > 0 && list.size() < 2) {
            holder.iv.setVisibility(View.VISIBLE);
            holder.nine.setVisibility(View.GONE);
            GlideUtils.into(context, list.get(0), holder.iv);
        } else if (list.size() > 1) {
            holder.iv.setVisibility(View.GONE);
            holder.nine.setVisibility(View.VISIBLE);
            holder.nine.setUrlList(list);
        }

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImagePreviewActivity.class);
                intent.putExtra("imageList", (Serializable) list);
                intent.putExtra(Consts.START_ITEM_POSITION, 0);
                intent.putExtra(Consts.START_IAMGE_POSITION, 0);
                context.startActivity(intent);
            }
        });

        final int[] zanNum = {data.get(position).getFabulousNum()};
        holder.tvZanNum.setText(zanNum[0] + "");
        if (data.get(position).getIsZan() == 0) {
            Glide.with(context).load(R.mipmap.icon004).into(holder.ivZan);
        } else {
            Glide.with(context).load(R.mipmap.zan).into(holder.ivZan);
        }
        holder.llZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).getIsZan() == 0) {
                    Map<String, String> map = new LinkedHashMap<>();
                    map.put("businessId", data.get(position).getId() + "");
                    map.put("funCode", "CSWG");
                    ViseUtil.Get(context, NetUrl.AppShareListPraiseTimesclickLikes, map, new ViseUtil.ViseListener() {
                        @Override
                        public void onReturn(String s) {
                            zanNum[0] = zanNum[0] + 1;
                            holder.tvZanNum.setText(zanNum[0] + "");
                            data.get(position).setIsZan(1);
                            Glide.with(context).load(R.mipmap.zan).into(holder.ivZan);
                        }
                    });
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_header;
        private TextView tv_user;
        private TextView tv_status;
        private TextView tv_addtime;
        private LinearLayout ll_text;
        private TextView tv_fff;
        private LinearLayout ll_set;
        private TextView tv_content;
        private NineGridTestLayout nine;
        private LinearLayout ll_del;
        private LinearLayout ll_edit;
        private LinearLayout llZan;
        private ImageView ivZan;
        private TextView tvZanNum;
        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_header = itemView.findViewById(R.id.iv_header);
            tv_user = itemView.findViewById(R.id.tv_user);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_addtime = itemView.findViewById(R.id.tv_addtime);
            ll_text = itemView.findViewById(R.id.ll_text);
            tv_fff = itemView.findViewById(R.id.tv_fff);
            ll_set = itemView.findViewById(R.id.ll_set);
            tv_content = itemView.findViewById(R.id.tv_content);
            nine = itemView.findViewById(R.id.nine);
            ll_del = itemView.findViewById(R.id.ll_del);
            ll_edit = itemView.findViewById(R.id.ll_edit);
            llZan = itemView.findViewById(R.id.ll_zan);
            ivZan = itemView.findViewById(R.id.iv_zan);
            tvZanNum = itemView.findViewById(R.id.tv_zan_num);
            iv = itemView.findViewById(R.id.iv);
        }
    }

}
