package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.BasePresenter;
import com.example.zhiyicx.justdodagger2.base.BaseSubscriber;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class RegisterPresenter extends BasePresenter<IRegisterRepository, RegisterConstract.View> implements RegisterConstract.Presenter {

    @Inject
    public RegisterPresenter(IRegisterRepository iLoginRepository, RegisterConstract.View view) {
        super(iLoginRepository, view);
    }

    @Override
    public void register(String userName, String pwd) {
        mRepository.register(userName, pwd)
                .compose(mTransformer)
                .subscribe(new BaseSubscriber<Object>() {
                    @Override
                    protected void onFailed(int status, String reason) {
                        dealError(status, reason);
                    }

                    @Override
                    protected void onSuccess(Object o) {
                        mRootView.hideLoading();
                        mRootView.registerSuccess();
                    }
                });
    }
}
