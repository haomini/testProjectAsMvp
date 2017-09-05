package com.example.zhiyicx.justdodagger2.data.repository;

import com.example.zhiyicx.justdodagger2.base.BaseBean;
import com.example.zhiyicx.justdodagger2.data.remote.RegisterClient;
import com.example.zhiyicx.justdodagger2.data.remote.ServiceManager;
import com.example.zhiyicx.justdodagger2.modules.register.IRegisterRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class RegisterRepository implements IRegisterRepository {

    private final RegisterClient mClient;

    @Inject
    public RegisterRepository(ServiceManager sManager) {
        this.mClient = sManager.getRegisterClient();
    }

    @Override
    public Observable<BaseBean> register(String userName, String pwd) {
//        return Observable
//                .just(UserManager.getInstance().insertUser(userName, pwd));
        return mClient.register(userName, pwd);
    }
}
