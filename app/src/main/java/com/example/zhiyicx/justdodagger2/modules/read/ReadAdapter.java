package com.example.zhiyicx.justdodagger2.modules.read;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.data.bean.ReadBean;
import com.example.zhiyicx.justdodagger2.modules.read.detail.ReadDetailActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/31
 * @Contact 605626708@qq.com
 */

public class ReadAdapter extends CommonAdapter<ReadBean> {

    public ReadAdapter(Context context, List<ReadBean> datas) {
        super(context, R.layout.item_video, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ReadBean readBean, int position) {
        TextView name = holder.getTextView(R.id.name);
        name.setText(readBean.getName());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ReadDetailActivity.class)
                        .putExtra("web", readBean.getPath()));
            }
        });
    }
}
