package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppCenterqueryListBean;
import com.guoyu.fuseapp.dialog.DialogCustom;
import com.guoyu.fuseapp.net.NetUrl;
import com.guoyu.fuseapp.util.GlideUtils;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2020/1/19.
 */

public class AppCenterItemAdapter extends RecyclerView.Adapter<AppCenterItemAdapter.ViewHolder> {

    private Context context;
    private List<AppCenterqueryListBean.DataBean.AppCentersBean> data;

    public AppCenterItemAdapter(List<AppCenterqueryListBean.DataBean.AppCentersBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_more_gongneng_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        GlideUtils.into(context, NetUrl.BASE_URL+data.get(position).getTitlePic(), holder.iv);
        holder.tv.setText(data.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInstallByread(data.get(position).getSkipPage())){
                    open(data.get(position).getSkipPage());
                }else {
                    DialogCustom dialogCustom = new DialogCustom(context, "未安装APP，是否去下载", new DialogCustom.OnYesListener() {
                        @Override
                        public void onYes() {
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            //此处填写更新apk地址
                            Uri apk_url = Uri.parse(data.get(position).getSkipUrl());
                            intent.setData(apk_url);
                            context.startActivity(intent);
                        }
                    });
                    dialogCustom.show();
                }
            }
        });
    }

    private boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    private void open(String p){
        PackageManager packageManager = context.getPackageManager();
        Intent intent= packageManager.getLaunchIntentForPackage(p);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
