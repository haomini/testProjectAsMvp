package com.example.zhiyicx.justdodagger2;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

@dagger.Component(modules = PresenterModule.class)
public interface Component {
    void inject(MainActivity injectData);
}
