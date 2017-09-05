package com.example.zhiyicx.justdodagger2.data.repository;

import com.example.zhiyicx.justdodagger2.base.BaseBean;
import com.example.zhiyicx.justdodagger2.data.remote.LoginClient;
import com.example.zhiyicx.justdodagger2.data.remote.ServiceManager;
import com.example.zhiyicx.justdodagger2.modules.login.ILoginRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoginRepository implements ILoginRepository {

    private LoginClient mClient;

    @Inject
    public LoginRepository(ServiceManager sManager) {
        mClient = sManager.getLoginClient();
    }

    @Override
    public Observable<BaseBean> login(String userName, String pwd) {
//        return Observable
//                .just(UserManager.getInstance().queryUserWithPwd(userName, pwd));
        return mClient.login(userName, pwd);
    }
}
