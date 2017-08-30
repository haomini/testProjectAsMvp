package com.example.zhiyicx.justdodagger2.modules.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.modules.audio.EmptyFragment;
import com.example.zhiyicx.justdodagger2.modules.my.MineFragment;
import com.example.zhiyicx.justdodagger2.modules.read.ReadFragment;
import com.example.zhiyicx.justdodagger2.modules.video.VideoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class HomeFragment extends Fragment {
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
    @BindView(R.id.space)
    View space;
    Unbinder unbinder;

    private View mRootView;
    private VideoFragment videoFragment;
    private MineFragment mineFragment;
    private EmptyFragment emptyFragment;
    private ReadFragment readFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, mRootView);
        space.setVisibility(View.GONE);
        selectHome();
        return mRootView;
    }

    @OnClick({R.id.ll_home, R.id.ll_find, R.id.ll_message, R.id.ll_mine})
    public void onViewClicked(View view) {
        space.setVisibility(View.VISIBLE);
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
}
