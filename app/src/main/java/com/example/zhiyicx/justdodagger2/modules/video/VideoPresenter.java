package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.base.BasePresenter;
import com.example.zhiyicx.justdodagger2.base.BaseSubscriber;
import com.example.zhiyicx.justdodagger2.data.bean.Video;

import java.util.List;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

public class VideoPresenter extends BasePresenter<IVideoRepository, VideoContract.View> implements VideoContract.Presenter{

    @Inject
    public VideoPresenter(IVideoRepository r, VideoContract.View view) {
        super(r, view);
    }

    @Override
    public void getVideoList() {
        mRepository.getVideoList()
                .compose(mTransformer)
                .subscribe(new BaseSubscriber<List<Video>>() {
                    @Override
                    protected void onFailed(int status, String reason) {
                        dealError(status, reason);
                    }

                    @Override
                    protected void onSuccess(List<Video> videos) {
                        mRootView.showSnackSuccessMessage("更新成功");
                        mRootView.refreshDate(videos);
                    }
                });
    }
}
