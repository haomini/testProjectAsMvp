package com.example.zhiyicx.justdodagger2.modules.read;

import android.support.v7.widget.LinearLayoutManager;
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

public class ReadFragment extends BaseFragment {
    @BindView(R.id.recycler_read)
    RecyclerView recyclerRead;

    private ReadAdapter mAdapter;

    @Override
    protected void initView() {
        mAdapter = new ReadAdapter(getContext(), getReadBean());
        recyclerRead.setAdapter(mAdapter);
        recyclerRead.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerRead.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.divider_len)));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_read;
    }

    public List<ReadBean> getReadBean() {
        List<ReadBean> list = new ArrayList<>();
        ReadBean bean0 = new ReadBean();
        bean0.setName("跟我一起学，WebView");
        bean0.setPath("http://blog.csdn.net/abc5382334/article/details/23934101");
        list.add(bean0);

        ReadBean bean1 = new ReadBean();
        bean1.setName("百度一下");
        bean1.setPath("http://www.baidu.com");
        list.add(bean1);

        ReadBean bean2 = new ReadBean();
        bean2.setName("更我一起学系列{2}");
        bean2.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean2);

        ReadBean bean3 = new ReadBean();
        bean3.setName("更我一起学系列{3}");
        bean3.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean3);

        ReadBean bean4 = new ReadBean();
        bean4.setName("更我一起学系列{4}");
        bean4.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean4);

        ReadBean bean5 = new ReadBean();
        bean5.setName("更我一起学系列{5}");
        bean5.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean5);

        ReadBean bean6 = new ReadBean();
        bean6.setName("更我一起学系列{6}");
        bean6.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean6);

        ReadBean bean7 = new ReadBean();
        bean7.setName("更我一起学系列{7}");
        bean7.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean7);

        ReadBean bean8 = new ReadBean();
        bean8.setName("更我一起学系列{8}");
        bean8.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean8);


        ReadBean bean9 = new ReadBean();
        bean9.setName("更我一起学系列{9}");
        bean9.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean9);

        ReadBean bean10 = new ReadBean();
        bean10.setName("更我一起学系列{10}");
        bean10.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean10);

        ReadBean bean11 = new ReadBean();
        bean11.setName("更我一起学系列{11}");
        bean11.setPath("http://www.cnblogs.com/keanuyaoo/archive/2013/09/04/3301826.html");
        list.add(bean11);
        return list;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "阅读吧";
    }
}
