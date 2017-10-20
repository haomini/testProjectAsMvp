package com.example.zhiyicx.justdodagger2.test;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/10/20
 * @Contact 605626708@qq.com
 */

public class FooterFragment extends BaseFragment {
    @BindView(R.id.observer_recycler)
    ObservableRecyclerView observerRecycler;

    @Override
    protected void initView() {

    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

    @Override
    protected void initData() {
        observerRecycler.setAdapter(new CommonAdapter<String>(getContext(), R.layout.recycler_item, getTestList()) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                ((TextView) holder.getView(R.id.tv_label)).setText(s);
            }
        });

        observerRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private List<String> getTestList() {
        List<String> list = new ArrayList<>();
        list.add("看啊啊看看");
        list.add("卡戴珊就爱看");
        list.add("卡戴珊就爱看");
        list.add("卡戴珊就爱看");
        list.add("卡戴珊就爱看");
        return list;
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.recycler_view;
    }

    @Override
    protected boolean isLastFragment() {
        return false;
    }
}
