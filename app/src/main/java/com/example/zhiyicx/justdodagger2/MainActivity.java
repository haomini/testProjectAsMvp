package com.example.zhiyicx.justdodagger2;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter, MainFragment> {

    @Override
    protected MainFragment getFragment() {
        return new MainFragment();
    }

    @Override
    protected void daggerForm() {
        DaggerComponent
                .builder()
                .presenterModule(new PresenterModule(mFragment))
                .build()
                .inject(this);
    }
}
