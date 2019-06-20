package com.hegd.recycleviewdemo.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hegd.recycleviewdemo.R;

/**
 * Created by 何国栋 on 2019/6/20.
 */

public class FooterLoadMoreViewHolder extends BaseViewHolder implements View.OnClickListener {


    public Context mContext;
    public ProgressBar pbLoading;
    public TextView tvLoading;
    public LinearLayout llEnd;

    public FooterLoadMoreViewHolder(View itemView) {
        super(itemView);
        initViewsAndEvents(itemView);
    }


    private void initViewsAndEvents(View itemView) {
        //fbi
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
        pbLoading = itemView.findViewById(R.id.pb_loading);
        tvLoading = itemView.findViewById(R.id.tv_loading);

        llEnd = itemView.findViewById(R.id.ll_end);

    }

    @Override
    public void bindViewData(Object data) {
        //no-op
    }

    @Override
    public void onClick(View v) {
        //no-op
    }
}
