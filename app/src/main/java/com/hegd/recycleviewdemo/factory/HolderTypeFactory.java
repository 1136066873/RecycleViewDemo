package com.hegd.recycleviewdemo.factory;

import android.view.View;
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

    public static final int TYPE1HOLDER_ITEM_LAYOUT = R.layout.layout_item_type1_mulittype;

    public static final int TYPE2HOLDER_ITEM_LAYOUT = R.layout.layout_item_type2_mulittype;

    @Override
    public int type(Type1Bean holder) {
        return TYPE1HOLDER_ITEM_LAYOUT;
    }

    @Override
    public int type(Type2Bean holder) {
        return TYPE2HOLDER_ITEM_LAYOUT;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(int type, View itemView) {
        switch (type) {
            case TYPE1HOLDER_ITEM_LAYOUT:
                return new Type1ViewHolder(itemView);
            case TYPE2HOLDER_ITEM_LAYOUT:
                return new Type2ViewHolder(itemView);
            default:
                return null;
        }
    }
}
