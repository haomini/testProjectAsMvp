package com.example.zhiyicx.justdodagger2.base;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.zhiyicx.justdodagger2.base.BaseSubscriber.ERROR_FOR_NET;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public abstract class BasePresenter<IR, V extends IBaseView> implements IBasePresenter {

    protected IR mRepository;
    protected V mRootView;

    protected Observable.Transformer mTransformer = observable -> ((Observable) observable).subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    public BasePresenter(IR r, V v) {
        this.mRepository = r;
        this.mRootView = v;
    }

    @Inject
    public void setUpView() {
        mRootView.setPresenter(this);
    }

    @Override
    public void dealError(int status, String reason) {
        mRootView.hideLoading();
        if (status == ERROR_FOR_NET) {
            mRootView.showSnackErrorMessage(BaseApplication.getApp().getString(R.string.error_for_net));
        } else {
            mRootView.showSnackErrorMessage(reason);
        }
    }
}
