package com.hegd.recycleviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 何国栋 on 2019/4/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public Context mContext;
    public List<String> mDatas;

    public ItemAdapter(Context context,List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局并转化为 View
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        //将 View 传递给 RecycleView 封装好的 ViewHolder
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        //用数据源的元素代替此 position 上的内容
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv ;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.id_num);
        }
    }
}
