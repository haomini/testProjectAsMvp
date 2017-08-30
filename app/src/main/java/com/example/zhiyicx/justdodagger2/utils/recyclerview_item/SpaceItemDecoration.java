package com.example.zhiyicx.justdodagger2.utils.recyclerview_item;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * @Describe recyclerView item space decoration
 * @Author zhouhao
 * @Date 2017/8/3
 * @Contact 605626708@qq.com
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int width, height;

    public SpaceItemDecoration(int height) {
        this(height, 0);
    }

    public SpaceItemDecoration(int height, int weight) {
        this.height = height;
        this.width = weight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        if (layoutManager instanceof GridLayoutManager
                || layoutManager instanceof StaggeredGridLayoutManager) { //网格 或者 瀑布
            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
            int ori = ((GridLayoutManager) layoutManager).getOrientation();
            int position = parent.getChildLayoutPosition(view);
            if (position % spanCount == 0) {
                if (ori == GridLayoutManager.VERTICAL) {
                    outRect.set(0, height, 0, 0);
                } else {
                    outRect.set(width, 0, 0, 0);
                }
            } else {
                outRect.set(width, height, 0, 0);
            }
        } else { //线性
            int ori = ((LinearLayoutManager) layoutManager).getOrientation();
            if (ori == LinearLayoutManager.VERTICAL) {
                outRect.set(0, height, 0, 0);
            } else {
                outRect.set(width, 0, 0, 0);
            }
        }
    }
}
