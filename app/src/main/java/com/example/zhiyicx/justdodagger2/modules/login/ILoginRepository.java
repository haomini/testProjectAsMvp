package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.BaseBean;

import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public interface ILoginRepository {
    Observable<BaseBean> login(String userName, String pwd);
}
