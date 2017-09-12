package com.example.zhiyicx.justdodagger2.modules.my;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class MineFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected boolean isLastFragment() {
        return true;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "我的";
    }
}
