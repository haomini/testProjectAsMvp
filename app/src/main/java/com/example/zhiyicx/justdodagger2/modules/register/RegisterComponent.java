package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.base.InjectComponent;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

@Component(modules = RegisterPresenterModule.class)
public interface RegisterComponent extends InjectComponent<RegisterActivity> {
}
