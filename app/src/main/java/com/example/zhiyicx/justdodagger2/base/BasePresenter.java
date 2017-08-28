package com.example.zhiyicx.justdodagger2.base;

import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public abstract class BasePresenter<R, V extends IBaseView> implements IBasePresenter {

    protected R mRepository;
    protected V mRootView;

    public BasePresenter(R r, V v) {
        this.mRepository = r;
        this.mRootView = v;
    }

    @Inject
    public void setUpView() {
        mRootView.setPresenter(this);
    }
}
