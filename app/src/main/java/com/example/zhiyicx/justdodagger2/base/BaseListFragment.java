package com.example.zhiyicx.justdodagger2.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.i.IBaseListPresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseListView;
import com.example.zhiyicx.justdodagger2.utils.recyclerview_item.SpaceItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhy.adapter.recyclerview.wrapper.EmptyWrapper;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/12
 * @Contact 605626708@qq.com
 */

public abstract class BaseListFragment<P extends IBaseListPresenter, T> extends BaseFragment<P>
        implements IBaseListView<P, T> {

    public final static int DEFAULT_PAGE_SIZE = 20;

    @BindView(R.id.default_refresh_layout)
    public SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.default_recycler)
    public RecyclerView mRecycler;

    protected RecyclerView.Adapter mAdapter;
    protected HeaderAndFooterWrapper<RecyclerView.Adapter> mHeaderAndFooterWrapper;
    protected EmptyWrapper<RecyclerView.Adapter> mEmptyWrapper;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<T> mList = new ArrayList<>();
    protected int mPage;

    @Override
    protected void initView() {
        mPresenter.requestNetData(mPage, false);
    }

    @Override
    protected void initData() {
        mAdapter = getAdapter();
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper<>(mAdapter);
        mEmptyWrapper = new EmptyWrapper<>(mHeaderAndFooterWrapper);
        mEmptyWrapper.setEmptyView(getFullEmptyView());
        mRecycler.addItemDecoration(new SpaceItemDecoration(getSpaceHeight(), getSpaceWidth()));
        mLayoutManager = getLayoutManager();
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mHeaderAndFooterWrapper);
    }

    protected void setFullEmpty() {
        if (!(mRecycler.getAdapter() instanceof EmptyWrapper))
            mRecycler.setAdapter(mEmptyWrapper);
    }

    protected void setLastEmpty() {
        if (mRecycler.getAdapter() instanceof EmptyWrapper) {
            mRecycler.setAdapter(mHeaderAndFooterWrapper);
        }
        mHeaderAndFooterWrapper.addFootView(getLastEmptyView());
        mHeaderAndFooterWrapper.notifyDataSetChanged();
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.default_list_fragment;
    }

    @Override
    protected boolean useOverScroll() {
        return false;
    }

    @Override
    public void requestNetSuccess(List<T> list, boolean isLoadMore) {
        if (isLoadMore) {
            if (list == null || list.size() == 0) { // 空数据
                setLastEmpty();
                mRefreshLayout.setEnableLoadmore(false);
            } else if (list.size() < DEFAULT_PAGE_SIZE) { // 小于默认条数
                mList.addAll(list);
                setLastEmpty();
                mRefreshLayout.setEnableLoadmore(false);
            } else { // 正常
                mList.addAll(list);
                mHeaderAndFooterWrapper.notifyDataSetChanged();
                mPage++;
            }
            mRefreshLayout.finishLoadmore();
        } else {
            if (list == null || list.size() == 0) { // 空数据
                setFullEmpty();
                mRefreshLayout.setEnableLoadmore(false);
            } else if (list.size() < DEFAULT_PAGE_SIZE) { // 小于默认条数
                mList.addAll(list);
                setLastEmpty();
                mRefreshLayout.setEnableLoadmore(false);
            } else { // 正常
                mList.clear();
                mList.addAll(list);
                mHeaderAndFooterWrapper.notifyDataSetChanged();
            }
            mPage = 0;
            mRefreshLayout.finishRefresh();
        }
    }

    /**
     * 设置布局管理器
     *
     * @return
     */
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    /**
     * 设置item间隔高
     *
     * @return
     */
    protected int getSpaceHeight() {
        return (int) getResources().getDimension(R.dimen.margin_small);
    }

    /**
     * 设置item间隔宽
     *
     * @return
     */
    protected int getSpaceWidth() {
        return 0;
    }

    /**
     * 设置adapter
     *
     * @return
     */
    protected abstract RecyclerView.Adapter getAdapter();

    protected View getLastEmptyView() {
        return getActivity().getLayoutInflater().inflate(R.layout.default_list_last_empty, null);
    }

    protected View getFullEmptyView() {
        return getActivity().getLayoutInflater().inflate(R.layout.default_list_empty, null);
    }
}
