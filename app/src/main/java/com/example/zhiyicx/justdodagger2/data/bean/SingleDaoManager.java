package com.example.zhiyicx.justdodagger2.data.bean;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/19
 * @Contact 605626708@qq.com
 */

@Singleton
public class SingleDaoManager {
    private VideoEntryDao mVideoEntryDao;

    @Inject
    public SingleDaoManager(VideoEntryDao videoEntryDao) {
        mVideoEntryDao = videoEntryDao;
    }

    public VideoEntryDao getVideoEntryDao() {
        return mVideoEntryDao;
    }

}
