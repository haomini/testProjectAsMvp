package com.example.zhiyicx.justdodagger2.modules.read.detail;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;
import com.example.zhiyicx.justdodagger2.base.BasePresenter;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/31
 * @Contact 605626708@qq.com
 */

public class ReadDetailActivity extends BaseActivity<BasePresenter, ReadDetailFragment> {
    @Override
    protected ReadDetailFragment getFragment() {
        return ReadDetailFragment.newInstance(getIntent().getExtras());
    }

    @Override
    protected void daggerForm() {

    }

    @Override
    public void onBackPressed() {
        mFragment.onBackPressed();
    }
}
