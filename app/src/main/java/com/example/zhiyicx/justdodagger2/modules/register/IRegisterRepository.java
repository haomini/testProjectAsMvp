package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.BaseBean;

import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public interface IRegisterRepository {
    Observable<BaseBean> register(String userName, String pwd);
}
