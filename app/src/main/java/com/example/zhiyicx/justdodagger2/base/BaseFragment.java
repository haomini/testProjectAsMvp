package com.example.zhiyicx.justdodagger2.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tsnackbar.widget.TSnackbar;
import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/28
 * @Contact 605626708@qq.com
 */

public abstract class BaseFragment<P extends IBasePresenter> extends RxFragment implements IBaseView<P> {

    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.parent_view)
    NestedScrollView parentView;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    private Unbinder unbinder;
    protected View mDocerView;
    protected RxPermissions mRxPermissions;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDocerView = inflater.inflate(R.layout.activity_main, null);
        unbinder = ButterKnife.bind(this, mDocerView);
        getContentView(inflater);
        if (usePermissions()) {
            mRxPermissions = new RxPermissions(getActivity());
            mRxPermissions.setLogging(true);
        }
        initView();
        return mDocerView;
    }

    private void getContentView(LayoutInflater inflater) {
        View contentView = inflater.inflate(getBodyLayout(), null);
        parentView.addView(contentView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showSnackErrorMessage(CharSequence s) {
        showSnackMessage(s, TSnackbar.ERROR);
    }

    @Override
    public void showSnackSuccessMessage(CharSequence s) {
        showSnackMessage(s, TSnackbar.SUCCESS);
    }

    @Override
    public void showSnackLoadingMessage(CharSequence s) {
        showSnackMessage(s, TSnackbar.LOADING);
    }

    protected void showSnackMessage(CharSequence s, @TSnackbar.Prompt int prompt) {
        TSnackbar.make(getView(), s, TSnackbar.LENGTH_SHORT, TSnackbar.APPEAR_FROM_TOP)
                .setPrompt(prompt)
                .setCallback(new TSnackbar.Callback() {
                    @Override
                    public void onDismissed(TSnackbar TSnackbar, @DismissEvent int event) {
                        showWhenSnackDismissed();
                    }
                })
                .show();
    }

    protected abstract void initView();

    protected abstract void initData();

    @LayoutRes
    protected int getBodyLayout() {
        return 0x0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected boolean usePermissions() {
        return false;
    }

    protected void showWhenSnackDismissed() {

    }
}
