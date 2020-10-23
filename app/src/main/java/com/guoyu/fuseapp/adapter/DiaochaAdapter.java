package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppBusQuestionquestionAllBean;
import com.guoyu.fuseapp.page.DiaochawenjuanDetailsActivity;
import com.guoyu.fuseapp.util.SpUtils;
import com.guoyu.fuseapp.util.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2020/10/15.
 */

public class DiaochaAdapter extends RecyclerView.Adapter<DiaochaAdapter.ViewHolder> {

    private Context context;
    private List<AppBusQuestionquestionAllBean.DataBean> data;

    public DiaochaAdapter(List<AppBusQuestionquestionAllBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_diaocha, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv.setText(data.get(position).getQuestionClassify());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(position).getIsHide() == 0){
                    Intent intent = new Intent();
                    intent.setClass(context, DiaochawenjuanDetailsActivity.class);
                    intent.putExtra("id", data.get(position).getId()+"");
                    intent.putExtra("sm", "0");
                    context.startActivity(intent);
                }else if(data.get(position).getIsHide() == 1){
                    if(SpUtils.getReal(context).equals("2")){
                        Intent intent = new Intent();
                        intent.setClass(context, DiaochawenjuanDetailsActivity.class);
                        intent.putExtra("id", data.get(position).getId()+"");
                        intent.putExtra("sm", "1");
                        context.startActivity(intent);
                    }else {
                        ToastUtil.showShort(context, "需实名认证才能填写此问卷");
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
