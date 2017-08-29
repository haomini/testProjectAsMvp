package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */


public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterFragment> {
    @Override
    protected RegisterFragment getFragment() {
        return new RegisterFragment();
    }

    @Override
    protected void daggerForm() {
        DaggerRegisterComponent
                .builder()
                .registerPresenterModule(new RegisterPresenterModule(mFragment))
                .build()
                .inject(this);
    }
}
