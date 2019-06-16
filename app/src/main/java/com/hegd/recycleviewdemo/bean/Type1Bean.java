package com.hegd.recycleviewdemo.bean;

import com.hegd.recycleviewdemo.decorate.Visitable;
import com.hegd.recycleviewdemo.factory.TypeFactory;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class Type1Bean implements Visitable {

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
