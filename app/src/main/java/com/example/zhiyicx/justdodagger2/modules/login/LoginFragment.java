package com.example.zhiyicx.justdodagger2.modules.login;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.base.config.ConstantConfig;
import com.example.zhiyicx.justdodagger2.widget.button.LoadingButton;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoginFragment extends BaseFragment<LoginConstract.Presenter> implements LoginConstract.View {
    @BindView(R.id.login)
    LoadingButton login;

    @Override
    protected void initView() {
        initListener();
    }

    private void initListener() {
        RxView.clicks(login)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> {
                    showLoading();
                    login.postDelayed(() -> hideLoading(), 3000);
                });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void showLoading() {
        login.setEnabled(false);
        login.handleAnimation();
    }

    @Override
    public void hideLoading() {
        login.setEnabled(false);
        login.hideAnimation();
    }

    @Override
    public void loginSuccess() {

    }
}
