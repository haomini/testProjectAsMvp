package com.example.zhiyicx.justdodagger2.modules.home;

import android.os.Build;
import android.transition.Explode;
import android.view.Window;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;
import com.example.zhiyicx.justdodagger2.base.BasePresenter;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class HomeActivity extends BaseActivity<BasePresenter, HomeFragment> {
    @Override
    protected HomeFragment getFragment() {
        return new HomeFragment();
    }

    @Override
    protected void daggerForm() {

    }

    @Override
    protected void doBeforeCreate() {
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }
    }

    @Override
    public void onBackPressed() {
        mFragment.onBackPressed();
    }
}
