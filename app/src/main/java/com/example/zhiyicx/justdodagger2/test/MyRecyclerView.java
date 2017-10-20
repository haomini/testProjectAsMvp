package com.example.zhiyicx.justdodagger2.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/10/20
 * @Contact 605626708@qq.com
 */

public class MyRecyclerView extends ObservableScrollView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:

        }
        return super.onTouchEvent(ev);
    }
}
