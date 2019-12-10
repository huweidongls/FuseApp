package com.guoyu.fuseapp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.guoyu.fuseapp.R;
import com.guoyu.fuseapp.bean.XiaoquListBean;

import java.util.ArrayList;
import java.util.List;

import me.zhouzhuo.zzletterssidebar.adapter.BaseSortListViewAdapter;
import me.zhouzhuo.zzletterssidebar.viewholder.BaseViewHolder;

/**
 * Created by Administrator on 2019/10/22.
 */

public class ShequListAdapter extends BaseSortListViewAdapter<XiaoquListBean.DataBean, ShequListAdapter.ViewHolder> implements Filterable {

    private Context context;
    private List<XiaoquListBean.DataBean> data;

    private List<XiaoquListBean.DataBean> mFilterList = new ArrayList<>();

    public ShequListAdapter(Context ctx, List<XiaoquListBean.DataBean> datas) {
        super(ctx, datas);
        this.context = ctx;
        this.data = datas;
        this.mFilterList = datas;
    }

    @Override
    public int getLayoutId() {
        return R.layout.recyclerview_shequ_list;
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        ViewHolder holder = new ViewHolder();
        holder.tvName = (TextView) view.findViewById(R.id.tv);
        return holder;
    }

    @Override
    public void bindValues(ViewHolder viewHolder, int position) {
        viewHolder.tvName.setText(mFilterList.get(position).getCommName());
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
                    List<XiaoquListBean.DataBean> filteredList = new ArrayList<>();
//                    for (String str : mSourceList) {
//                        //这里根据需求，添加匹配规则
//                        if (str.contains(charString)) {
//                            filteredList.add(str.);
//                        }
//                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).getCommName().contains(charString)) {
                            filteredList.add(data.get(i));
                        }
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
                mFilterList = (List<XiaoquListBean.DataBean>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends BaseViewHolder {
        protected TextView tvName;
    }

}
