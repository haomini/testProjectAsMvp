package com.example.zhiyicx.justdodagger2.base.i;

import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/12
 * @Contact 605626708@qq.com
 */

public interface IBaseListView<P extends IBaseListPresenter, T> extends IBaseView<P> {

    void requestNetSuccess(List<T> list, boolean isLoadMore);
}
