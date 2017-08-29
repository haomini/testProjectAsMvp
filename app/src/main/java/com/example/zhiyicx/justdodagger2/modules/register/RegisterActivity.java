package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;

/**
 * Created by haomini on 2017/8/29.
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
