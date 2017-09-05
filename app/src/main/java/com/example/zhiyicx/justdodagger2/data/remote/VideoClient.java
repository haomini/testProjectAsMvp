package com.example.zhiyicx.justdodagger2.data.remote;

import com.example.zhiyicx.justdodagger2.base.BaseBean;
import com.example.zhiyicx.justdodagger2.data.bean.Video;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

import static com.example.zhiyicx.justdodagger2.base.dagger.app.AppConfig.VIDEO;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

public interface VideoClient {

    @GET(VIDEO)
    Observable<BaseBean<List<Video>>> getVideoList();
}
