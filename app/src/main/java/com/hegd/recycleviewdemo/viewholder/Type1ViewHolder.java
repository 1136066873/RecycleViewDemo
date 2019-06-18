package com.hegd.recycleviewdemo.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.hegd.recycleviewdemo.R;
import com.hegd.recycleviewdemo.bean.Type1Bean;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class Type1ViewHolder extends BaseViewHolder implements View.OnClickListener {

    private ImageView iv_url;
    private TextView id_num;
    private Context mContext;

    public Type1ViewHolder(View itemView) {
        super(itemView);
        initViewsAndEvents(itemView);
    }

    private void initViewsAndEvents(View itemView) {
        //fbi
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
        iv_url = itemView.findViewById(R.id.iv_url);
        iv_url.setOnClickListener(this);
        id_num = itemView.findViewById(R.id.id_num);
        id_num.setOnClickListener(this);
    }

    @Override
    public void bindViewData(Object data) {
        //set data
        Glide.with(mContext).load(((Type1Bean)data).getItemImageUrl()).into(iv_url);
        id_num.setText(((Type1Bean)data).getItemTitle());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_url:
                Toast.makeText(mContext, "图 -" + id_num.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_num:
                Toast.makeText(mContext, "标题 -" + id_num.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
