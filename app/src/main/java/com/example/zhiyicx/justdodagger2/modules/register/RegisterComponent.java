package com.example.zhiyicx.justdodagger2.modules.register;

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
@Component(dependencies = AppComponent.class, modules = RegisterPresenterModule.class)
public interface RegisterComponent extends InjectComponent<RegisterActivity> {
}
