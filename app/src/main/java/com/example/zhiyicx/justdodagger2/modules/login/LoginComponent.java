package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.base.InjectComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.app.AppComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.scope.PerActivity;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = LoginPresenterModule.class)
public interface LoginComponent extends InjectComponent<LoginActivity> {
}
