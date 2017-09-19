package com.example.zhiyicx.justdodagger2.base.dagger.app;

import com.example.zhiyicx.justdodagger2.data.bean.DaoSession;
import com.example.zhiyicx.justdodagger2.data.bean.VideoEntryDao;

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
public class SingleDaoModule {

    @Provides
    @Singleton
    VideoEntryDao provideVideoEntryDao(DaoSession daoSession){
        return daoSession.getVideoEntryDao();
    }
}
