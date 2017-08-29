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
        //将文字放左边, 移动画布使之导致中间
        setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.frame_loading_white);
    }

    public void handleAnimation() {
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        this.setEnabled(false);
        drawable.start();
    }

    public void hideAnimation() {
        this.setEnabled(true);
        drawable.selectDrawable(0);
        drawable.stop();
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        int bodyWidth = 0;
        if (drawables != null && drawables[0] != null) {
            Drawable drawableLeft = drawables[0];
            bodyWidth = getCompoundDrawablePadding() + drawableLeft.getIntrinsicWidth();
        }
        float textWidth = getPaint().measureText(getText().toString());
        bodyWidth += textWidth;
        canvas.translate((getWidth() - bodyWidth) / 2, 0);
        super.onDraw(canvas);
    }
}
