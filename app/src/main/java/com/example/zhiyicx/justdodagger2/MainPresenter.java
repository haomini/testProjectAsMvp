package com.example.zhiyicx.justdodagger2;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

public class MainPresenter implements Contract.Presenter{

    Repository repository;
    Contract.View mRootView;


    @Inject
    public MainPresenter(Repository r, Contract.View v) {
        this.repository = r;
        this.mRootView = v;
    }

    @Inject
    public void setUpPresenter() {
        mRootView.setPresenter(this);
    }

    // 继承自 专有功能接口 的方法实现
    @Override
    public void doA() {
        repository.doRepository();
    }

    @Override
    public void ibpToast() {
        mRootView.doShowSnack();
    }
}
