package com.example.zhiyicx.justdodagger2.base.dagger.app;

import android.app.Application;

import com.example.zhiyicx.justdodagger2.base.BaseApplication;
import com.example.zhiyicx.justdodagger2.data.bean.DaoMaster;
import com.example.zhiyicx.justdodagger2.data.bean.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/19
 * @Contact 605626708@qq.com
 */

@Module
public class GreenDaoModule {

    @Provides
    @Singleton
    DaoSession provideDaoSession(Application application) {
        return new DaoMaster(new DaoMaster.DevOpenHelper(application, BaseApplication.DBName)
                .getWritableDb())
                .newSession();
    }
}
