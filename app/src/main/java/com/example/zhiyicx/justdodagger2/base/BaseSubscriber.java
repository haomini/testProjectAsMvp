package com.example.zhiyicx.justdodagger2.base;

import rx.Subscriber;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public abstract class BaseSubscriber<T> extends Subscriber<BaseBean<T>> {

    public final static int ERROR_FOR_NET = -3;
    public final static int SUCCESS = 0;

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onFailed(ERROR_FOR_NET, null);
    }

    @Override
    public void onNext(BaseBean<T> t) {
        if (t.getStatus() == SUCCESS) {
            onSuccess(t.getResult());
        } else {
            onFailed(t.getStatus(), t.getReason());
        }
    }

    protected abstract void onFailed(int status, String reason);

    protected abstract void onSuccess(T t);
}
