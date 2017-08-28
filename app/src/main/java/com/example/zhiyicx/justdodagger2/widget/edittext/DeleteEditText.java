package com.example.zhiyicx.justdodagger2.widget.edittext;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.zhiyicx.justdodagger2.R;

/**
 * @Describe 可全删除的EditText
 * @Author zhouhao
 * @Date 2017/8/18
 * @Contact 605626708@qq.com
 */

public class DeleteEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher, View.OnTouchListener {
    @DrawableRes
    public static int DEFAULT_DELETE_ICON = R.mipmap.login_inputbox_clean;
    public static int DEFAULT_PADDING_RIGHT;
    private final GestureDetector gestureDetector;

    public DeleteEditText(Context context) {
        this(context, null);
    }

    public DeleteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        DEFAULT_PADDING_RIGHT = (int) getResources().getDimension(R.dimen.margin_small);
        addTextChangedListener(this);
        setOnTouchListener(this);
        gestureDetector = new GestureDetector(context, listener);
        setPadding(0, 0, DEFAULT_PADDING_RIGHT, 0);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (TextUtils.isEmpty(s)) {
            setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(0, 0, DEFAULT_DELETE_ICON, 0);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getRawX() >= v.getWidth() - DEFAULT_PADDING_RIGHT - getResources().getDrawable(DEFAULT_DELETE_ICON).getIntrinsicWidth()) {
            gestureDetector.onTouchEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }

    private GestureDetector.OnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            getText().clear();
            return true;
        }
    };
}
