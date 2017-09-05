package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;
import com.example.zhiyicx.justdodagger2.data.bean.Video;

import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

public interface VideoContract {
    interface View extends IBaseView<Presenter> {
        void refreshDate(List<Video> list);
    }

    interface Presenter extends IBasePresenter {
        void getVideoList();
    }
}
