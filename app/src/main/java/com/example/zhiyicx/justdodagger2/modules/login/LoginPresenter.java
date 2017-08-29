package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.BasePresenter;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoginPresenter extends BasePresenter<ILoginRepository, LoginConstract.View> implements LoginConstract.Presenter {

    @Inject
    public LoginPresenter(ILoginRepository iLoginRepository, LoginConstract.View view) {
        super(iLoginRepository, view);
    }

    @Override
    public void login(String userName, String pwd) {
        mRepository.login(userName, pwd)
                .compose(mTransformer)
                .subscribe(objectBaseBean -> {

                });

    }
}
