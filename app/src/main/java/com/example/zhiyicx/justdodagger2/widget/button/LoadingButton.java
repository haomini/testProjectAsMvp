package com.example.zhiyicx.justdodagger2.widget.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

import com.example.zhiyicx.justdodagger2.R;

/**
 * @Describe 带loading的Button
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoadingButton extends android.support.v7.widget.AppCompatButton {

    AnimationDrawable drawable;

    public LoadingButton(Context context) {
        this(context, null);
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //将文字放中间
        setGravity(Gravity.CENTER);
        drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.frame_loading_white);
    }

    public void handleAnimation() {
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        //将文字放左边, 移动画布使之导致中间
        setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        this.setEnabled(false);
        drawable.start();
    }

    public void hideAnimation() {
        this.setEnabled(true);
        drawable.selectDrawable(0);
        drawable.stop();
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        setGravity(Gravity.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableLeft = drawables[0];
            if (drawableLeft != null) {
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawableLeft.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                canvas.translate((getWidth() - bodyWidth) / 2, 0);
            }
        }
        super.onDraw(canvas);
    }
}
