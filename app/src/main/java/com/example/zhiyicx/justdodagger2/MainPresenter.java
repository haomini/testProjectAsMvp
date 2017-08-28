package com.example.zhiyicx.justdodagger2;

import com.example.zhiyicx.justdodagger2.base.BasePresenter;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

public class MainPresenter extends BasePresenter<Contract.Repository, Contract.View> implements Contract.Presenter {

    @Inject
    public MainPresenter(Contract.Repository r, Contract.View v) {
        super(r, v);
    }

    @Inject
    public void setUpPresenter() {
        mRootView.setPresenter(this);
    }

    // 继承自 专有功能接口 的方法实现
    @Override
    public void doA() {
        mRepository.doRepository();
    }

    @Override
    public void ibpToast() {
        mRootView.doShowSnack();
    }
}
