package com.example.zhiyicx.justdodagger2.modules.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhiyicx.justdodagger2.base.BaseApplication;
import com.example.zhiyicx.justdodagger2.base.BaseListFragment;
import com.example.zhiyicx.justdodagger2.data.bean.Video;
import com.example.zhiyicx.justdodagger2.modules.video.adapter.RecyclerNormalAdapter;
import com.example.zhiyicx.justdodagger2.modules.video.holder.RecyclerItemNormalHolder;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class VideoFragment extends BaseListFragment<VideoContract.Presenter, Video> implements VideoContract.View {
    private boolean mFull;

    @Inject
    VideoPresenter mVideoPresenter;

    @Override
    protected void initView() {

        DaggerVideoComponent
                .builder()
                .appComponent(BaseApplication.AppComponentHolder.getAppComponent())
                .videoPresenterModule(new VideoPresenterModule(this))
                .build()
                .inject(this);

        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
                lastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(RecyclerItemNormalHolder.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        if (!mFull) {
                            GSYVideoPlayer.releaseAllVideos();
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new RecyclerNormalAdapter(getContext(), mList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GSYVideoPlayer.releaseAllVideos();
    }

    @Override
    protected boolean isLastFragment() {
        return true;
    }

    public boolean onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(getActivity())) {
            return true;
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            mFull = false;
        } else {
            mFull = true;
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "视频吧";
    }
}
