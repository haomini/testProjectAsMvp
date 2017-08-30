package com.example.zhiyicx.justdodagger2.modules.audio;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/31
 * @Contact 605626708@qq.com
 */

public class EmptyFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_empty;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "音乐吧";
    }
}
