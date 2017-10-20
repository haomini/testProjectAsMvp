package com.example.zhiyicx.justdodagger2.widget.linear;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @Describe 刚好达到满行的tag标签
 * @Author zhouhao
 * @Date 2017/10/9
 * @Contact 605626708@qq.com
 */

public class TagLinearLayout extends LinearLayout {

    // 17sp default
    private static final float DEFAULT_SIZE = 17 /*sp*/;
    private static final float DEFAULT_MARGIN = 8 /*dp*/;

    private String[] params;
    private float textSize = DEFAULT_SIZE;
    private float mTagMargin;
    private TextPaint mPaint;
    private TagClickedListener mTagClickedListener;
    private TypedArray typedArray;

    public TagLinearLayout(Context context) {
        this(context, null);
    }

    public TagLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);

        mTagMargin = DEFAULT_MARGIN * getResources().getDisplayMetrics().density;
        mPaint = new TextPaint();

        mPaint.setTextSize(getResources().getDisplayMetrics().scaledDensity * textSize);

        TypedValue typedValue = new TypedValue();
        getContext().getTheme()
                .resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);

        int[] attribute = new int[]{android.R.attr.selectableItemBackground};
        typedArray = getContext().getTheme().obtainStyledAttributes(typedValue.resourceId, attribute);
    }

    public void setArrays(String... params) {
        this.params = params;
        measureMarginAndSize();
        addTags();
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    /**
     * 重新测量文字的高宽和间距
     */
    public void measureMarginAndSize(){
        if (params == null) throw new AssertionError("no text for add");
        final float left = getPaddingLeft();
        final float right = getPaddingRight();
        final float scrollWidth = getResources().getDisplayMetrics().widthPixels;
        float textLength = 0;
        for (int i = 0; i < params.length; i++) {
            textLength += mPaint.measureText(params[i]);
        }
        float sum = textLength + mTagMargin * (params.length + 1) + left + right;
        if (sum < scrollWidth) {
            mTagMargin = (scrollWidth - textLength) / (params.length + 1);
        } else {
            textSize = (scrollWidth - mTagMargin * (params.length + 1) + left + right) * textSize / textLength;
        }
    }

    /**
     * 添加自适应标签
     */
    public void addTags() {
        LinearLayout.LayoutParams vLayoutParams = (LayoutParams) getLayoutParams();
        vLayoutParams.leftMargin = (int) (mTagMargin / 2);
        vLayoutParams.rightMargin = (int) (mTagMargin / 2);
        setLayoutParams(vLayoutParams);

        for (int i = 0; i < params.length; i++) {

            // init
            TextView tv = new TextView(getContext());
            tv.setTextSize(textSize);
            tv.setText(params[i]);
            tv.setBackgroundDrawable(typedArray.getDrawable(0));
            LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = (int) (mTagMargin / 2);
            layoutParams.rightMargin = (int) (mTagMargin / 2);
            tv.setLayoutParams(layoutParams);

            // add listener
            final int position = i;
            tv.setOnClickListener(v -> {
                if(mTagClickedListener != null)
                mTagClickedListener.onTagClicked(tv, position);
            });

            addView(tv);
        }
        typedArray.recycle();
    }

    public void setTagClickedListener(TagClickedListener listener){
        this.mTagClickedListener = listener;
    }

    public interface TagClickedListener{
        void onTagClicked(View v, int position);
    }
}
