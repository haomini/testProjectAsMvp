package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.base.i.IBaseListPresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseListView;
import com.example.zhiyicx.justdodagger2.data.bean.Video;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

public interface VideoContract {
    interface View extends IBaseListView<Presenter, Video> {
    }

    interface Presenter extends IBaseListPresenter {
    }
}
