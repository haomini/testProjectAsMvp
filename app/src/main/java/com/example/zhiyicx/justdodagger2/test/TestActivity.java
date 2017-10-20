package com.example.zhiyicx.justdodagger2.test;

import android.support.v4.app.Fragment;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/10/20
 * @Contact 605626708@qq.com
 */

public class TestActivity extends BaseActivity {
    @Override
    protected Fragment getFragment() {
        return new TestFragment();
    }

    @Override
    protected void daggerForm() {

    }
}
