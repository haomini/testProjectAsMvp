package com.example.zhiyicx.justdodagger2.modules.audio;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
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

public class AudioAdapter extends CommonAdapter<ReadBean> {

    public AudioAdapter(Context context, List<ReadBean> datas) {
        super(context, R.layout.item_find, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ReadBean readBean, int position) {
        TextView name = holder.getTextView(R.id.name);
        ImageView img = holder.getImageViwe(R.id.img_read);

        img.setImageResource(readBean.getRes());

        name.setText(readBean.getName());
        holder.getConvertView().setOnClickListener(v -> mContext.startActivity(new Intent(mContext, ReadDetailActivity.class)
                .putExtra("web", readBean.getPath())));
    }
}
