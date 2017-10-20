package com.example.zhiyicx.justdodagger2;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/20
 * @Contact 605626708@qq.com
 */

public interface TestInterface {

    @GET
    Observable<String> getBaidu(@Url String url);
}
