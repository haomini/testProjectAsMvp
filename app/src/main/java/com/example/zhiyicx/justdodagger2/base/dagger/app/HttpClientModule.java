package com.example.zhiyicx.justdodagger2.base.dagger.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/3
 * @Contact 605626708@qq.com
 */

@Module
public class HttpClientModule {

    @Provides
    @Singleton
    public Retrofit ProvideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL_LOCAL)// 域名
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 使用 rxjava
                .addConverterFactory(ScalarsConverterFactory.create())// 使用Scalars
                .addConverterFactory(GsonConverterFactory.create())// 使用 Gson
                .build();
    }
}
