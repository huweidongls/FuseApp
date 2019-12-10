package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.MoreGongnengBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/11.
 */

public class MoreGongnengAdapter extends RecyclerView.Adapter<MoreGongnengAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<MoreGongnengBean.DataBean> data;

    private List<MoreGongnengBean.DataBean> mFilterList = new ArrayList<>();

    public MoreGongnengAdapter(List<MoreGongnengBean.DataBean> data) {
        this.data = data;
        this.mFilterList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_more_gongneng, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(mFilterList.get(position).getTitle());
        List<MoreGongnengBean.DataBean.ListBean> list = mFilterList.get(position).getList();
        MoreGongnengItemAdapter itemAdapter = new MoreGongnengItemAdapter(list);
        GridLayoutManager manager = new GridLayoutManager(context, 4);
        holder.rv.setLayoutManager(manager);
        holder.rv.setAdapter(itemAdapter);
    }

    @Override
    public int getItemCount() {
        return mFilterList == null ? 0 : mFilterList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            //执行过滤操作
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    //没有过滤的内容，则使用源数据
                    mFilterList = data;
                } else {
                    List<MoreGongnengBean.DataBean> filteredList = new ArrayList<>();
//                    for (String str : mSourceList) {
//                        //这里根据需求，添加匹配规则
//                        if (str.contains(charString)) {
//                            filteredList.add(str.);
//                        }
//                    }
                    Map<String, List<MoreGongnengBean.DataBean.ListBean>> map = new LinkedHashMap<>();
                    List<MoreGongnengBean.DataBean.ListBean> list;
                    for (int i = 0; i < data.size(); i++) {
                        String title = data.get(i).getTitle();
                        List<MoreGongnengBean.DataBean.ListBean> list1 = data.get(i).getList();
                        list = new ArrayList<>();
                        for (int j = 0; j < data.get(i).getList().size(); j++){
                            if(list1.get(j).getFunName().contains(charString)){
                                list.add(list1.get(j));
                            }
                        }
                        if(list.size()>0){
                            map.put(title, list);
                        }
                    }

                    //遍历map中的键
                    for (String key : map.keySet()) {
                        filteredList.add(new MoreGongnengBean.DataBean(key, map.get(key)));
                    }

                    mFilterList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilterList;
                return filterResults;
            }

            //把过滤后的值返回出来
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilterList = (List<MoreGongnengBean.DataBean>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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
