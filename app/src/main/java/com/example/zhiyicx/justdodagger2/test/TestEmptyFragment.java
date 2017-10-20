package com.example.zhiyicx.justdodagger2.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/10/20
 * @Contact 605626708@qq.com
 */

public class TestEmptyFragment extends Fragment {

    @BindView(R.id.observer_recycler)
    ObservableRecyclerView observerRecycler;
    Unbinder unbinder;
    private View view;

    private int privateTag;

    public int getPrivateTag() {
        return privateTag;
    }

    public void setPrivateTag(int privateTag) {
        this.privateTag = privateTag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_view, null);
        unbinder = ButterKnife.bind(this, view);
        observerRecycler.setId(privateTag);
        observerRecycler.setAdapter(new CommonAdapter<String>(getContext(), R.layout.recycler_item, getTestList()) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                ((TextView) holder.getView(R.id.tv_label)).setText(s);
            }
        });

        observerRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
}
