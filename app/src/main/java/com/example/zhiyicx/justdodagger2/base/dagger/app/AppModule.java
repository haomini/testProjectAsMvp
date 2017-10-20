package com.example.zhiyicx.justdodagger2.base.dagger.app;

import com.example.zhiyicx.justdodagger2.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhoa
 * @Date 2017/08/21
 * @Contact 6056267080@qq.com
 */

@Module
public class AppModule {
    private BaseApplication mApplication;

    public AppModule(BaseApplication application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public BaseApplication provideApplication() {
        return mApplication;
    }

}
