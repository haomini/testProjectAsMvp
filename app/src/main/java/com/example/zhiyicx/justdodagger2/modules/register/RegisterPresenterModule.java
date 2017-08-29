package com.example.zhiyicx.justdodagger2.modules.register;

import com.example.zhiyicx.justdodagger2.data.repository.RegisterRepository;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

@Module
public class RegisterPresenterModule {
    RegisterConstract.View mView;

    public RegisterPresenterModule(RegisterConstract.View view) {
        this.mView = view;
    }

    @Provides
    RegisterConstract.View getView() {
        return mView;
    }

    @Provides
    IRegisterRepository provideRepository(RegisterRepository repository) {
        return repository;
    }
}
