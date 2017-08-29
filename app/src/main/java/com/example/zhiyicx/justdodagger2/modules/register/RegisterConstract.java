package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public interface RegisterConstract {
    interface View extends IBaseView<Presenter> {
        void registerSuccess();
    }

    interface Presenter extends IBasePresenter {
        void register(String userName, String pwd);
    }
}
