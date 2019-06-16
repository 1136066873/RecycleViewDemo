package com.hegd.recycleviewdemo.factory;

import android.view.View;
import com.hegd.recycleviewdemo.bean.Type1Bean;
import com.hegd.recycleviewdemo.bean.Type2Bean;
import com.hegd.recycleviewdemo.viewholder.BaseViewHolder;


/**
 * Created by 何国栋 on 2019/6/17.
 */

public interface TypeFactory {

    int type(Type1Bean bean);

    int type(Type2Bean bean);

    BaseViewHolder onCreateViewHolder(int type, View itemView);
}
