package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.data.repository.VideoRepository;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

@Module
public class VideoPresenterModule {
    VideoContract.View mView;

    public VideoPresenterModule(VideoContract.View view) {
        this.mView = view;
    }

    @Provides
    VideoContract.View getView() {
        return mView;
    }

    @Provides
    IVideoRepository provideRepository(VideoRepository repository) {
        return repository;
    }
}
