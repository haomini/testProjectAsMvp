package com.example.zhiyicx.justdodagger2.base.dagger.app;

import android.app.Application;

import com.example.zhiyicx.justdodagger2.base.InjectComponent;
import com.example.zhiyicx.justdodagger2.base.ServiceModule;
import com.example.zhiyicx.justdodagger2.data.remote.ServiceManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/5
 * @Contact 605626708@qq.com
 */

@Singleton
@Component(modules = {HttpClientModule.class, ServiceModule.class,
        GreenDaoModule.class, SingleDaoModule.class})
public interface AppComponent extends InjectComponent<Application>{

    //服务管理器,retrofitApi
    ServiceManager serviceManager();
}
