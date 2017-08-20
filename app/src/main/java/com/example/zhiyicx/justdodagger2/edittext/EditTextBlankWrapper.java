package com.example.zhiyicx.justdodagger2.edittext;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.reflect.Field;

/**
 * @Describe 提供一个为任意EditText, 在特殊位置添加特殊符号的方法
 * @Author zhouhao
 * @Date 2017/8/18
 * @Contact 605626708@qq.com
 */

public class EditTextBlankWrapper<T extends EditText> implements TextWatcher {
    public T editText;                  // 实际EditText
    private int index;                  // 已经添加字符串的个数
    private CharSequence add;           // 待添加字符串
    private int type;                   // 0无序位置, 1有序位置 etc.

    private int[] params;               // 无序位置, 位置0暂不处理
    private int start, perLen;          // 有序位置, 等差起始位置和差距

    private int len;                    // 改变前长度

    /**
     * 传入无序位置添加特殊字符
     *
     * @param editText
     * @param add
     * @param params
     */
    public EditTextBlankWrapper(T editText, CharSequence add, int[] params) {
        this.editText = editText;
        this.params = params;
        this.add = add;
        this.type = 0;
        initListener();
    }

    /**
     * 传入等差位置添加特殊位置
     *
     * @param editText
     * @param add
     * @param start
     * @param perLen
     */
    public EditTextBlankWrapper(T editText, CharSequence add, int start, int perLen) {
        this.editText = editText;
        this.add = add;
        this.start = start;
        this.perLen = perLen;
        this.type = 1;
        initListener();
    }

    private void initListener() {
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        len = s.length();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text = s.toString();
        if (needAdd(text)) {
            s.insert(s.length() - 1, add);
            index++;
        }
        if (needDel(text)) {
            s.delete(s.length() - add.length(), s.length());
            index--;
        }
    }

    /**
     * 判断是否应该添加特殊字符
     *
     * @param text
     * @return
     */
    public boolean needAdd(String text) {
        if (type == 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] + index * add.length() == len)
                    return len < text.length();
            }
            return false;
        } else {
            if ((add.length() + perLen) * index + start == len)
                return len < text.length();
            return false;
        }
    }

    /**
     * 判断是否应该删除连带的特殊字符
     *
     * @param text
     * @return
     */
    public boolean needDel(String text) {
        if (type == 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] + index * add.length() == len - 1)
                    return len > text.length();
            }
            return false;
        } else {
            if ((add.length() + perLen) * index - perLen + start == len - 1)
                return len > text.length();
            return false;
        }
    }

    /**
     * 获取设置的最大长度
     *
     * @return
     */
    public int getMaxLength() {
        int length = 0;
        try {
            InputFilter[] inputFilters = editText.getFilters();
            for (InputFilter filter : inputFilters) {
                Class<?> c = filter.getClass();
                if (c.getName().equals("android.text.InputFilter$LengthFilter")) {
                    Field[] f = c.getDeclaredFields();
                    for (Field field : f) {
                        if (field.getName().equals("mMax")) {
                            field.setAccessible(true);
                            length = (Integer) field.get(filter);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    /**
     * 获得实际的EditText
     *
     * @return
     */
    public T getContent() {
        return editText;
    }

    /**
     * 合计添加的次数
     *
     * @return
     */
    public int getAddCount() {
        return index;
    }
}
