package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.i.IBasePresenter;
import com.example.zhiyicx.justdodagger2.base.i.IBaseView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public interface LoginConstract {
    interface View extends IBaseView<Presenter> {
        void loginSuccess();
    }

    interface Presenter extends IBasePresenter {
        void login(String userName, String pwd);
    }
}
