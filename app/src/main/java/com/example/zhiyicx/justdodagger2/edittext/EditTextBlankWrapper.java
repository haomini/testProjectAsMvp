package com.example.zhiyicx.justdodagger2.edittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @Describe 提供一个为任意EditText, 在特殊位置添加特殊符号的方法
 * @notify 注意 : 位置0不处理哈.
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
        initListener();
        this.params = params;
        this.add = add;
        this.type = 0;
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
        initListener();
        this.add = add;
        this.start = start;
        this.perLen = perLen;
        this.type = 1;
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
            s.append(add);
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
                if (params[i] + index * add.length() == len + 1)
                    return len < text.length();
            }
            return false;
        } else {

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
            return false;
        }
    }

    /**
     * 检查传入的位置是否包含0
     *
     * @return
     */
    public boolean containsZero() {
        for (int i = 0; i < params.length; i++) {
            if (params[i] == 0)
                return true;
        }
        return false;
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
