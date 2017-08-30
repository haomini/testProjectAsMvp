package com.example.zhiyicx.justdodagger2.modules.video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.data.bean.Video;
import com.example.zhiyicx.justdodagger2.modules.video.holder.RecyclerItemNormalHolder;

import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class RecyclerNormalAdapter extends RecyclerView.Adapter {
    private final static String TAG = "RecyclerBaseAdapter";

    private List<Video> itemDataList = null;
    private Context context = null;

    public RecyclerNormalAdapter(Context context, List<Video> itemDataList) {
        this.itemDataList = itemDataList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_video_item_normal, parent, false);
        final RecyclerView.ViewHolder holder = new RecyclerItemNormalHolder(context, v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        RecyclerItemNormalHolder recyclerItemViewHolder = (RecyclerItemNormalHolder) holder;
        recyclerItemViewHolder.setRecyclerBaseAdapter(this);
        recyclerItemViewHolder.onBind(position, itemDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemDataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    public void setListData(List<Video> data) {
        itemDataList = data;
        notifyDataSetChanged();
    }
}
