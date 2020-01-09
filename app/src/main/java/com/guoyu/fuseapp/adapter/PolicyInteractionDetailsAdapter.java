package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyu.fuseapp.R;

import java.util.List;

/**
 * Created by Administrator on 2020/1/9.
 */

public class PolicyInteractionDetailsAdapter extends RecyclerView.Adapter<PolicyInteractionDetailsAdapter.ViewHolder>{
    private Context context;
    private List<String> data;
    public PolicyInteractionDetailsAdapter(List<String> data){
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
    public void onBindViewHolder(PolicyInteractionDetailsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
