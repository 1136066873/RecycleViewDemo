package com.hegd.recycleviewdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
//https://juejin.im/post/5a2907136fb9a0450e7603b2
//https://www.jianshu.com/p/c3c6c81adfbc
//https://blog.csdn.net/lb377463323/article/details/48023171


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mDatas;
    private ItemAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.id_recyclerview);
        initData();
        mAdapter = new ItemAdapter(MainActivity.this,mDatas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener(new ItemAdapter.onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(final View view, String data) {
                Toast.makeText(MainActivity.this, "which item is clicked  -> " + data, Toast.LENGTH_SHORT).show();
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
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        mDatas = new ArrayList<>();
        for(int i = 0 ; i < 15 ; i++ ){
            mDatas.add( "item  " + i );
        }
    }
}
