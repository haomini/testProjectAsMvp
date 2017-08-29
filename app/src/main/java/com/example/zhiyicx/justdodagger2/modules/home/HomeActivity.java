package com.example.zhiyicx.justdodagger2.modules.home;

import com.example.zhiyicx.justdodagger2.base.BaseActivity;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class HomeActivity extends BaseActivity {
    @Override
    protected BaseFragment getFragment() {
        return new HomeFragment();
    }

    @Override
    protected void daggerForm() {

    }
}
