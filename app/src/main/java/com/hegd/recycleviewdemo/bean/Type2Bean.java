package com.hegd.recycleviewdemo.bean;

import com.hegd.recycleviewdemo.decorate.Visitable;
import com.hegd.recycleviewdemo.factory.TypeFactory;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class Type2Bean implements Visitable {

    public String itemImageUrl;

    public String itemTitle;

    public Type2Bean(String itemImageUrl, String itemTitle) {
        this.itemImageUrl = itemImageUrl;
        this.itemTitle = itemTitle;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    @Override
    public String toString() {
        return "Type1Bean{" +
                "itemImageUrl='" + itemImageUrl + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                '}';
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
