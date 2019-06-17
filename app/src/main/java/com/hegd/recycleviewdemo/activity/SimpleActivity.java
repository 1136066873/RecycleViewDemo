package com.hegd.recycleviewdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.hegd.recycleviewdemo.ItemAdapter;
import com.hegd.recycleviewdemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class SimpleActivity extends AppCompatActivity {

    private RecyclerView mSimpleRecyclerView;
    private List<String> mDatas;
    private ItemAdapter mSimpleRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        mSimpleRecyclerView = findViewById(R.id.recyclerview_simple);
        initData();
        mSimpleRecyclerViewAdapter = new ItemAdapter(SimpleActivity.this,mDatas);
        mSimpleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSimpleRecyclerViewAdapter.setOnItemClickListener(new ItemAdapter.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(final View view, String data) {
                Toast.makeText(SimpleActivity.this, "which item is clicked  -> " + data, Toast.LENGTH_SHORT).show();
                //设置点击时的动画
                view.animate()
                        .translationZ(100f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                view.animate()
                                        .translationZ(1f)
                                        .setDuration(500)
                                        .start();
                            }
                        }).start();
            }
        });
        //添加分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
        mSimpleRecyclerView.addItemDecoration(divider);
        mSimpleRecyclerView.setAdapter(mSimpleRecyclerViewAdapter);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for(int i = 0 ; i < 15 ; i++ ){
            mDatas.add( "item  " + i );
        }
    }
}
