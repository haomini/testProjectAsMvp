package com.example.zhiyicx.justdodagger2;

import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public interface Contract {
    interface Presenter extends IBasePresenter {
        void doA();

        void ibpToast();
    }

    interface View extends IBaseView<Presenter> {
        void doShowSnack();
    }

    interface Repository {
        void doRepository();
    }
}
