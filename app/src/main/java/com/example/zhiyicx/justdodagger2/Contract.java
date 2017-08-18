package com.example.zhiyicx.justdodagger2;

import com.example.zhiyicx.justdodagger2.base.BaseView;
import com.example.zhiyicx.justdodagger2.base.IBasePresenter;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/14
 * @Contact 605626708@qq.com
 */

public interface Contract {
    interface Presenter extends IBasePresenter {
        void doA();
    }

    interface View extends BaseView<Presenter> {
        void doShowSnack();
    }

    interface Repository {

    }
}
