package com.example.zhiyicx.justdodagger2.data.repository;

import com.example.zhiyicx.justdodagger2.base.BaseBean;
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

    @Inject
    public RegisterRepository() {
    }

    @Override
    public Observable<BaseBean<Object>> register(String userName, String pwd) {
        return null;
    }
}
