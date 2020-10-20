package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.AppBusQuestionselectAllQuestionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/10/15.
 */

public class DiaochaDetailsAdapter extends RecyclerView.Adapter<DiaochaDetailsAdapter.ViewHolder> {

    private Context context;
    private List<AppBusQuestionselectAllQuestionBean.DataBean> data;

    public DiaochaDetailsAdapter(List<AppBusQuestionselectAllQuestionBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_diaocha_details, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv.setText(data.get(position).getQuestionName());

        List<AppBusQuestionselectAllQuestionBean.DataBean.ListBean> list = data.get(position).getList();
        DiaochaDetailsItemAdapter itemAdapter = new DiaochaDetailsItemAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.rv.setLayoutManager(manager);
        holder.rv.setAdapter(itemAdapter);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rv = itemView.findViewById(R.id.rv);
        }
    }

}
