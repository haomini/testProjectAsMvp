package com.example.zhiyicx.justdodagger2.base;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public abstract class BasePresenter<R, V extends BaseView> implements IBasePresenter {

    R mRepository;
    V mRootView;

    public BasePresenter(R r, V v) {
        this.mRepository = r;
        this.mRootView = v;
    }

    @Inject
    public void setUpView() {
        mRootView.setPresenter(this);
    }

    @Override
    public void ibpToast() {

    }
}
