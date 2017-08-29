package com.example.zhiyicx.justdodagger2.modules.home;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.ll_home)
    LinearLayout mVideo;
    @BindView(R.id.ll_find)
    LinearLayout mMusic;
    @BindView(R.id.ll_message)
    LinearLayout mRead;
    @BindView(R.id.ll_mine)
    LinearLayout mMine;
    @BindView(R.id.controller)
    FrameLayout mController;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_home;
    }
}
