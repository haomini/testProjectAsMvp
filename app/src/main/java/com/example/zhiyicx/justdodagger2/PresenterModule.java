package com.example.zhiyicx.justdodagger2;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

@Module
public class PresenterModule {
    Contract.View fragment;

    public PresenterModule(Contract.View fragment) {
        this.fragment = fragment;
    }

    @Provides
    Contract.View getFragment() {
        return fragment;
    }

    @Provides
    Contract.Repository provideRepository(Repository repository) {
        return repository;
    }
}
