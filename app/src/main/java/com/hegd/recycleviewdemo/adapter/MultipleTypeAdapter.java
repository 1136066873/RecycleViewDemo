package com.hegd.recycleviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.hegd.recycleviewdemo.decorate.Visitable;
import com.hegd.recycleviewdemo.factory.HolderTypeFactory;
import com.hegd.recycleviewdemo.viewholder.BaseViewHolder;
import com.hegd.recycleviewdemo.viewholder.FooterLoadMoreViewHolder;
import java.util.List;
import static com.hegd.recycleviewdemo.factory.HolderTypeFactory.TYPE_FOOTER;

/**
 * Created by 何国栋 on 2019/6/17.
 */

public class MultipleTypeAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {

    public List mItems;
    public Context mContext;
    public HolderTypeFactory mHolderTypeFactory;
    private int mLoadState;
    // 正在加载
    public final int LOADING = 1;
    // 加载完成
    public final int LOADING_COMPLETE = 2;
    // 加载到底
    public final int LOADING_END = 3;

    public MultipleTypeAdapter(Context context, List items){
        mHolderTypeFactory = new HolderTypeFactory();
        mContext = context;
        mItems = items;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mHolderTypeFactory.onCreateViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if ( !(holder instanceof FooterLoadMoreViewHolder)){
            holder.bindViewData(mItems.get(position));
        } else {
            FooterLoadMoreViewHolder footViewHolder = (FooterLoadMoreViewHolder) holder;
            switch (mLoadState) {
                case LOADING: // 正在加载
                    footViewHolder.pbLoading.setVisibility(View.VISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.VISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_COMPLETE: // 加载完成
                    footViewHolder.pbLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.tvLoading.setVisibility(View.INVISIBLE);
                    footViewHolder.llEnd.setVisibility(View.GONE);
                    break;

                case LOADING_END: // 加载到底
                    footViewHolder.pbLoading.setVisibility(View.GONE);
                    footViewHolder.tvLoading.setVisibility(View.GONE);
                    footViewHolder.llEnd.setVisibility(View.VISIBLE);
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size() + 1;
    }

    @Override
    public void onClick(View itemView) {
    }

    @Override
    public int getItemViewType(int position) {
        if ( position == mItems.size()) {
            return TYPE_FOOTER;
        } else {
            return ((Visitable)mItems.get(position)).type(mHolderTypeFactory);
        }
    }

    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.mLoadState = loadState;
        notifyDataSetChanged();
    }

    //处理 recycleView 在使用 GridLayoutManager 布局时，footer 的显示的问题
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    // 如果当前是footer的位置，那么该item占据 x 个单元格，正常情况下占据1个单元格
                    return getItemViewType(position) == TYPE_FOOTER ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 注意：
     * 当自定义的 XxxAdapter 与自己写的 XxxViewHolder 都设置了点击事件，当点击recycleView 中的某一个
     * item 的时候，是 XxxViewHolder 中的点击事件被触发。
     */
}
