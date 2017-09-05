package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;
import com.example.zhiyicx.justdodagger2.base.BaseApplication;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginFragment> {
    @Override
    protected LoginFragment getFragment() {
        return new LoginFragment();
    }

    @Override
    protected void daggerForm() {
        DaggerLoginComponent
                .builder()
                .appComponent(BaseApplication.AppComponentHolder.getAppComponent())
                .loginPresenterModule(new LoginPresenterModule(mFragment))
                .build()
                .inject(this);
    }
}
