package com.example.zhiyicx.justdodagger2;

import com.example.zhiyicx.justdodagger2.base.dagger.app.HttpClientModule;

import org.junit.Test;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/20
 * @Contact 605626708@qq.com
 */

public class Dagger2Test {
    @Test
    public void doTest() {
        System.out.println("Dagger2Test" + "doTest(): " + JustForTest.isOne(1));
        System.out.println("test for v2");
    }

    @Test
    public void doThing() {
        Retrofit retrofit = new HttpClientModule().ProvideRetrofit();
        TestInterface testInterface = retrofit.create(TestInterface.class);

        Observable.Transformer transformer = o -> ((Observable<Object>)o);
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.immediate())
//                .unsubscribeOn(Schedulers.io());

        testInterface
                .getBaidu("http://app.qj622.com/api/v2/feeds?type=hot&after=2327&limit=20")
                .compose(transformer)
                .subscribe(System.out::println);
    }
}
