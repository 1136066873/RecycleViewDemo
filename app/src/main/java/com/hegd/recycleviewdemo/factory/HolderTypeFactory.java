package com.hegd.recycleviewdemo.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hegd.recycleviewdemo.R;
import com.hegd.recycleviewdemo.bean.Type1Bean;
import com.hegd.recycleviewdemo.bean.Type2Bean;
import com.hegd.recycleviewdemo.viewholder.BaseViewHolder;
import com.hegd.recycleviewdemo.viewholder.Type1ViewHolder;
import com.hegd.recycleviewdemo.viewholder.Type2ViewHolder;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class HolderTypeFactory implements TypeFactory {

    public static final int TYPE1  = 0;

    public static final int TYPE2  = 1;

    public static final int TYPE1HOLDER_ITEM_LAYOUT = R.layout.layout_item_type1_mulittype;

    public static final int TYPE2HOLDER_ITEM_LAYOUT = R.layout.layout_item_type2_mulittype;

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
                View view1 = LayoutInflater.from(parent.getContext()).inflate(TYPE1HOLDER_ITEM_LAYOUT, parent,false);
                //view1.setOnClickListener(this);
                return new Type1ViewHolder(view1);
            case TYPE2:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(TYPE2HOLDER_ITEM_LAYOUT, parent,false);
                //view2.setOnClickListener(this);
                return new Type2ViewHolder(view2);
            default:
                return null;
        }
    }
}
