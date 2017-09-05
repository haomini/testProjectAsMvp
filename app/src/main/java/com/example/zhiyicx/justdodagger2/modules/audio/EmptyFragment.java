package com.example.zhiyicx.justdodagger2.modules.audio;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.data.bean.ReadBean;
import com.example.zhiyicx.justdodagger2.utils.recyclerview_item.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/31
 * @Contact 605626708@qq.com
 */

public class EmptyFragment extends BaseFragment {
    @BindView(R.id.recycler_read)
    RecyclerView recyclerRead;

    private AudioAdapter mAdapter;

    @Override
    protected void initView() {
        mAdapter = new AudioAdapter(getContext(), getReadBean());
        recyclerRead.setAdapter(mAdapter);
        recyclerRead.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerRead.addItemDecoration(new SpaceItemDecoration(
                (int) getResources().getDimension(R.dimen.margin_small),
                (int) getResources().getDimension(R.dimen.margin_small))
        );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_read;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "发现吧";
    }

    public List<ReadBean> getReadBean() {
        List<ReadBean> list = new ArrayList<>();

        ReadBean bean1 = new ReadBean();
        bean1.setName("百度一下");
        bean1.setPath("http://www.baidu.com");
        bean1.setRes(R.mipmap.baidu);
        list.add(bean1);

        ReadBean bean3 = new ReadBean();
        bean3.setName("贴吧");
        bean3.setPath("https://tieba.baidu.com/?page=discovery");
        bean3.setRes(R.mipmap.tieba);
        list.add(bean3);

        ReadBean bean4 = new ReadBean();
        bean4.setName("微博");
        bean4.setPath("https://sina.cn/?wm=4007");
        bean4.setRes(R.mipmap.weibo);
        list.add(bean4);

        ReadBean bean5 = new ReadBean();
        bean5.setName("携程");
        bean5.setRes(R.mipmap.xiecheng);
        bean5.setPath("http://m.ctrip.com/html5/?sourceid=2386&allianceid=20642&sid=452281&sepopup=94&autoawaken=close");
        list.add(bean5);

        ReadBean bean6 = new ReadBean();
        bean6.setName("58同城");
        bean6.setRes(R.mipmap.tongcheng);
        bean6.setPath("http://m.58.com/cd/?utm_source=market&spm=b-31580022738699-me-f-805.uc_jp_0220");
        list.add(bean6);

        ReadBean bean2 = new ReadBean();
        bean2.setName("搜狐");
        bean2.setPath("https://m.sohu.com/?pvid=000115_3w_index&jump=front");
        bean2.setRes(R.mipmap.souhu);
        list.add(bean2);

        return list;
    }
}
