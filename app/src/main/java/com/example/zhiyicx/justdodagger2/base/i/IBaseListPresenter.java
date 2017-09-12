package com.example.zhiyicx.justdodagger2.base.i;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/12
 * @Contact 605626708@qq.com
 */

public interface IBaseListPresenter extends IBasePresenter {

    void requestNetData(int page, boolean isLoadMore);
}
