package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.data.repository.LoginRepository;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

@Module
public class LoginPresenterModule {
    LoginConstract.View mView;

    public LoginPresenterModule(LoginConstract.View view) {
        this.mView = view;
    }

    @Provides
    LoginConstract.View getView() {
        return mView;
    }

    @Provides
    ILoginRepository provideRepository(LoginRepository repository) {
        return repository;
    }
}
