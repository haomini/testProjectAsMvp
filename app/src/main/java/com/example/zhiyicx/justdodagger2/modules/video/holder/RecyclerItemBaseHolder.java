package com.example.zhiyicx.justdodagger2.modules.video.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */
public class RecyclerItemBaseHolder extends RecyclerView.ViewHolder {

    RecyclerView.Adapter recyclerBaseAdapter;

    ListVideoUtil listVideoUtil;

    public RecyclerItemBaseHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView.Adapter getRecyclerBaseAdapter() {
        return recyclerBaseAdapter;
    }

    public void setRecyclerBaseAdapter(RecyclerView.Adapter recyclerBaseAdapter) {
        this.recyclerBaseAdapter = recyclerBaseAdapter;
    }

    public ListVideoUtil getListVideoUtil() {
        return listVideoUtil;
    }

    public void setListVideoUtil(ListVideoUtil listVideoUtil) {
        this.listVideoUtil = listVideoUtil;
    }
}
