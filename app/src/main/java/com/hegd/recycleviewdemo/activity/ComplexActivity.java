package com.hegd.recycleviewdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.hegd.recycleviewdemo.R;
import com.hegd.recycleviewdemo.adapter.MultipleTypeAdapter;
import com.hegd.recycleviewdemo.bean.Type1Bean;
import com.hegd.recycleviewdemo.bean.Type2Bean;
import com.hegd.recycleviewdemo.listener.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class ComplexActivity extends AppCompatActivity {

    private RecyclerView mComplexRecyclerView;
    private List<Object> mDatas;
    private MultipleTypeAdapter mComplexRecyclerViewAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        initViews();
        initData();

        mComplexRecyclerViewAdapter = new MultipleTypeAdapter(ComplexActivity.this,mDatas);
        mComplexRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
        mComplexRecyclerView.addItemDecoration(divider);
        mComplexRecyclerView.setAdapter(mComplexRecyclerViewAdapter);
        mComplexRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                mComplexRecyclerViewAdapter.setLoadState(mComplexRecyclerViewAdapter.LOADING);

                if (mDatas.size() < 50) {//这个地方的数值大小应该是后台服务器返回来的数据的实际大小
                    // 模拟获取网络数据，延时1s
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    loadMoreData();
                                    mComplexRecyclerViewAdapter.setLoadState(mComplexRecyclerViewAdapter.LOADING_COMPLETE);
                                }
                            });
                        }
                    }, 1000);
                } else {
                    // 显示加载到底的提示
                    mComplexRecyclerViewAdapter.setLoadState(mComplexRecyclerViewAdapter.LOADING_END);
                }
            }
        });

    }

    private void initViews() {
        mComplexRecyclerView = findViewById(R.id.recyclerview_complex);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        // 设置刷新控件颜色
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#979797"));
        // 设置下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 刷新数据
                mDatas.clear();
                initData();
                mComplexRecyclerViewAdapter.notifyDataSetChanged();

                // 延时1s关闭下拉刷新
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, 1000);
            }
        });
    }

    private void loadMoreData() {
        for(int i = 0 ; i < 10 ; i++ ){
            mDatas.add(new Type1Bean("http://m.360buyimg.com/pop/jfs/t24616/349/8854905/77406/fe947d37/5b62b258N53dddc60.jpg","熊猫老虎，我是狮子 🦁 " + (mDatas.size() + 1)));
        }
    }

    private void initData() {
        if (mDatas == null)
        mDatas = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++ ){
            if (i % 2 == 0){
                mDatas.add(new Type1Bean("http://www.cctv.com/special/536/-1/25184/chengnian.jpg","老虎老虎，我是熊猫 🐼" + (i + 1)));
            }else {
                mDatas.add(new Type2Bean("https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=f1fc397a5edf8db1a8237436684ab631/241f95cad1c8a786648b72ec6709c93d71cf50aa.jpg","熊猫熊猫，我是老虎 🐯" + (i + 1)));
            }
        }
    }
}
