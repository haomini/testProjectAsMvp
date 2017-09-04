package com.example.zhiyicx.justdodagger2.base.dagger.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Describe
 * @Author zhouhoa
 * @Date 2017/08/21
 * @Contact 6056267080@qq.com
 */

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
        new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL_LOCAL)// 域名
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 使用 rxjava
                .addConverterFactory(ScalarsConverterFactory.create())// 使用Scalars
                .addConverterFactory(GsonConverterFactory.create())// 使用 Gson
                .build();
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

}
