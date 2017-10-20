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

public class MyScrollerView extends ObservableScrollView {
    public MyScrollerView(Context context) {
        super(context);
    }

    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (ev.getY() < 100 * getResources().getDisplayMetrics().density)
                    return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (ev.getRawY() >= 100 * getResources().getDisplayMetrics().density)
                    return true;
        }
        return super.onTouchEvent(ev);
    }
}
