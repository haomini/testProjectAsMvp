package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.InjectComponent;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

@Component(modules = LoginPresenterModule.class)
public interface LoginComponent extends InjectComponent<LoginActivity> {
}
