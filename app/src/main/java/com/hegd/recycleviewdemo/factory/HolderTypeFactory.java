package com.hegd.recycleviewdemo.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hegd.recycleviewdemo.R;
import com.hegd.recycleviewdemo.bean.Type1Bean;
import com.hegd.recycleviewdemo.bean.Type2Bean;
import com.hegd.recycleviewdemo.viewholder.BaseViewHolder;
import com.hegd.recycleviewdemo.viewholder.FooterLoadMoreViewHolder;
import com.hegd.recycleviewdemo.viewholder.Type1ViewHolder;
import com.hegd.recycleviewdemo.viewholder.Type2ViewHolder;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class HolderTypeFactory implements TypeFactory {

    public static final int TYPE1  = 0;

    public static final int TYPE2  = 1;

    // 脚布局
    public static final int TYPE_FOOTER = 2;

    public static final int TYPE1_HOLDER_ITEM_LAYOUT = R.layout.layout_item_type1_mulittype;

    public static final int TYPE2_HOLDER_ITEM_LAYOUT = R.layout.layout_item_type2_mulittype;

    public static final int TYPE_FOOTER_HOLDER_ITEM_LAYOUT = R.layout.layout_item_footer_mulittype;

    @Override
    public int type(Type1Bean holder) {
        return TYPE1;
    }

    @Override
    public int type(Type2Bean holder) {
        return TYPE2;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(int type, ViewGroup parent) {
        switch (type) {
            case TYPE1:
                View type1View = LayoutInflater.from(parent.getContext()).inflate(TYPE1_HOLDER_ITEM_LAYOUT, parent,false);
                return new Type1ViewHolder(type1View);
            case TYPE2:
                View type2View = LayoutInflater.from(parent.getContext()).inflate(TYPE2_HOLDER_ITEM_LAYOUT, parent,false);
                return new Type2ViewHolder(type2View);
            case TYPE_FOOTER:
                View typeFooterView = LayoutInflater.from(parent.getContext()).inflate(TYPE_FOOTER_HOLDER_ITEM_LAYOUT, parent,false);
                return new FooterLoadMoreViewHolder(typeFooterView);
            default:
                return null;
        }
    }
}
