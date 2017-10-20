package com.example.zhiyicx.justdodagger2.test;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/10/20
 * @Contact 605626708@qq.com
 */

public class TestFragment extends BaseFragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.observer_scroll)
    ObservableScrollView observerScroll;
    private int currentPage;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                TestEmptyFragment fragment = new TestEmptyFragment();
                fragment.setPrivateTag(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "你看看";
            }
        });
        tab.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        observerScroll.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            @Override
            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
                ObservableScrollView scrollView = (ObservableScrollView) viewPager.findViewById(currentPage);
                Log.e("onScrollChanged", "onScrollChanged(): " + scrollY);
            }

            @Override
            public void onDownMotionEvent() {

            }

            @Override
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {

            }
        });
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_header;
    }

    @Override
    protected boolean isLastFragment() {
        return false;
    }
}
