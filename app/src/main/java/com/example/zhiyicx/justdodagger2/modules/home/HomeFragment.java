package com.example.zhiyicx.justdodagger2.modules.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.modules.audio.EmptyFragment;
import com.example.zhiyicx.justdodagger2.modules.my.MineFragment;
import com.example.zhiyicx.justdodagger2.modules.read.ReadFragment;
import com.example.zhiyicx.justdodagger2.modules.video.VideoFragment;

import butterknife.BindView;
import butterknife.OnClick;

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

    private VideoFragment videoFragment;
    private MineFragment mineFragment;
    private EmptyFragment emptyFragment;
    private ReadFragment readFragment;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mVideo.performClick();
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_home;
    }

    @OnClick({R.id.ll_home, R.id.ll_find, R.id.ll_message, R.id.ll_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                selectHome();
                break;
            case R.id.ll_find:
                selectEmpty();
                break;
            case R.id.ll_message:
                selectRead();
                break;
            case R.id.ll_mine:
                selectMine();
                break;
        }
    }

    @Override
    protected boolean isLastFragment() {
        return false;
    }

    public void onBackPressed() {
        if (!videoFragment.onBackPressed()) {
            getActivity().finish();
        }
    }

    public void selectHome() {
        if (videoFragment == null)
            videoFragment = new VideoFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.controller, videoFragment)
                .addToBackStack(null)
                .commit();
    }

    public void selectMine() {
        if (mineFragment == null)
            mineFragment = new MineFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.controller, mineFragment)
                .addToBackStack(null)
                .commit();
    }

    public void selectEmpty() {
        if (emptyFragment == null)
            emptyFragment = new EmptyFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.controller, emptyFragment)
                .addToBackStack(null)
                .commit();
    }

    public void selectRead() {
        if (readFragment == null)
            readFragment = new ReadFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.controller, readFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

    @Override
    protected boolean useToolbarDivider() {
        return false;
    }

    @Override
    protected boolean setUseStatusBar() {
        return false;
    }
}
