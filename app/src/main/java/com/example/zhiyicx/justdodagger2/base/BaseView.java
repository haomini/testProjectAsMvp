package com.example.zhiyicx.justdodagger2.base;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public interface BaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
}
