package com.hegd.recycleviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 何国栋 on 2019/4/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>
        implements View.OnClickListener{

    public static final String TAG = "heguodong";
    public Context mContext;
    public List<String> mDatas;
    public onRecyclerViewItemClickListener mItemClickListener = null;

    public ItemAdapter(Context context,List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    /**
     * 暴露给别人可以设置监听
     * @param listener
     */
    public void setOnItemClickListener(onRecyclerViewItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v(TAG,"onCreateViewHolder() is called, parent is " + parent + " ; viewType is " + viewType) ;
        //加载布局并转化为 View
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        //设置监听
        itemView.setOnClickListener(this);
        //将 View 传递给 RecycleView 封装好的 ViewHolder
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Log.v(TAG,"onBindViewHolder() is called, holder is " + holder + " ; position is " + position) ;
        //用数据源的元素代替此 position 上的内容
        holder.tv.setText(mDatas.get(position));

        //把当前的位置以 TAG 的形式发送出去，方便在点击事件的时候使用这个位置
        holder.itemView.setTag(mDatas.get(position));//将数据保存在itemView的Tag中，以便点击时进行获取
    }

    @Override
    public int getItemCount() {
        Log.v(TAG,"getItemCount() is called, Item Count is " + mDatas.size() ) ;
        return mDatas.size();
    }

    @Override
    public void onClick(View itemView) {
        if (mItemClickListener != null){
            mItemClickListener.onItemClick(itemView,(String)itemView.getTag());
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv ;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.id_num);
        }
    }

    //添加 item 的点击事件回调
    public static interface onRecyclerViewItemClickListener {
        void onItemClick(View view,String data);
    }
}
