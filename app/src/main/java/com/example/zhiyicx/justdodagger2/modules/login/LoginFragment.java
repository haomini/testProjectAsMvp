package com.example.zhiyicx.justdodagger2.modules.login;

import android.content.Intent;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.base.config.ConstantConfig;
import com.example.zhiyicx.justdodagger2.modules.register.RegisterActivity;
import com.example.zhiyicx.justdodagger2.widget.button.LoadingButton;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
import com.example.zhiyicx.justdodagger2.widget.edittext.PasswordEditText;
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
    @BindView(R.id.et_complete_input)
    AppCompatAutoCompleteTextView etCompleteInput;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.et_login_phone)
    DeleteEditText etLoginPhone;
    @BindView(R.id.et_login_password)
    PasswordEditText etLoginPassword;
    @BindView(R.id.tv_error_tip)
    TextView tvErrorTip;
    @BindView(R.id.register)
    TextView mRegister;

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

        RxView.clicks(mRegister)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> {
                    startActivity(new Intent(getActivity(), RegisterActivity.class));
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
    public void showSnackErrorMessage(CharSequence s) {
        tvErrorTip.setText(s);
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

    @Override
    protected CharSequence setCenterTitle() {
        return "登陆";
    }
}
