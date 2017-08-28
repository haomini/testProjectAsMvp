package com.example.zhiyicx.justdodagger2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.zhiyicx.justdodagger2.R;

import javax.inject.Inject;

import butterknife.Unbinder;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/28
 * @Contact 605626708@qq.com
 */

public abstract class BaseActivity<P extends BasePresenter, F extends BaseFragment> extends AppCompatActivity {
    private Unbinder unbinder;
    @Inject
    protected P mPresenter;
    protected F mFragment;

    protected abstract F getFragment();

    protected abstract void daggerForm();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_bse_activity);
        initView();
    }

    protected void initView() {
        mFragment = getFragment();
        daggerForm();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.replacement, mFragment)
                .commit();
    }
}
