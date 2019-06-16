package com.hegd.recycleviewdemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     *绑定itemview 的数据
     */
    public abstract void bindViewData(T data);
}
