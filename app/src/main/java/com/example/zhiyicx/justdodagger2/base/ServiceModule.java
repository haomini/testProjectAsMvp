package com.example.zhiyicx.justdodagger2.base;

import com.example.zhiyicx.justdodagger2.data.remote.LoginClient;
import com.example.zhiyicx.justdodagger2.data.remote.RegisterClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zhiyicx on 2016/3/30.
 */
@Module
public class ServiceModule {

    /**
     * 登录相关的网络接口
     *
     * @param retrofit 网络框架
     * @return
     */
    @Singleton
    @Provides
    LoginClient provideLoginClient(Retrofit retrofit) {
        return retrofit.create(LoginClient.class);
    }

    /**
     * 注册相关的网络接口
     *
     * @param retrofit 网络框架
     * @return
     */
    @Singleton
    @Provides
    RegisterClient provideRegisterClient(Retrofit retrofit) {
        return retrofit.create(RegisterClient.class);
    }
}
