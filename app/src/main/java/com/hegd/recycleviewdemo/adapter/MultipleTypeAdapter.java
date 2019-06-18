package com.hegd.recycleviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.hegd.recycleviewdemo.decorate.Visitable;
import com.hegd.recycleviewdemo.factory.HolderTypeFactory;
import com.hegd.recycleviewdemo.viewholder.BaseViewHolder;
import java.util.List;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class MultipleTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {

    public List mItems;
    public Context mContext;
    public HolderTypeFactory mHolderTypeFactory;
    public onRecyclerViewItemClickListener mItemClickListener = null;

    public MultipleTypeAdapter(Context context, List items){
        mHolderTypeFactory = new HolderTypeFactory();
        mContext = context;
        mItems = items;
    }

    /**
     * 暴露给别人可以设置监听
     * @param listener
     */
    public void setOnItemClickListener(MultipleTypeAdapter.onRecyclerViewItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xxx, parent,false);
        //view.setOnClickListener(this);
        return mHolderTypeFactory.onCreateViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindViewData(mItems.get(position));
        //把当前的位置以 TAG 的形式发送出去，方便在点击事件的时候使用这个位置
        holder.itemView.setTag(mItems.get(position));//将数据保存在itemView的Tag中，以便点击时进行获取
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onClick(View itemView) {
        if (mItemClickListener != null){
            mItemClickListener.onItemClick(itemView,(String)itemView.getTag());
        }
    }

    //添加 item 的点击事件回调
    public static interface onRecyclerViewItemClickListener {
        void onItemClick(View view,String data);
    }

    @Override
    public int getItemViewType(int position) {
        return ((Visitable)mItems.get(position)).type(mHolderTypeFactory);
    }
}
