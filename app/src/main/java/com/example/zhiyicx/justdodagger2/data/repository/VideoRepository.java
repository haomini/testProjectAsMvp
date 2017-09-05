package com.example.zhiyicx.justdodagger2.data.repository;

import com.example.zhiyicx.justdodagger2.base.BaseBean;
import com.example.zhiyicx.justdodagger2.data.bean.Video;
import com.example.zhiyicx.justdodagger2.data.remote.ServiceManager;
import com.example.zhiyicx.justdodagger2.data.remote.VideoClient;
import com.example.zhiyicx.justdodagger2.modules.video.IVideoRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

public class VideoRepository implements IVideoRepository {


    private final VideoClient mClient;

    @Inject
    public VideoRepository(ServiceManager sManager) {
        this.mClient = sManager.getVideoClient();
    }

    @Override
    public Observable<BaseBean<List<Video>>> getVideoList() {
        return mClient.getVideoList();
    }
}
