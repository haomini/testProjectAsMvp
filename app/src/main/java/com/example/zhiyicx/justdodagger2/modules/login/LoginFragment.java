package com.example.zhiyicx.justdodagger2.modules.login;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.base.config.ConstantConfig;
import com.example.zhiyicx.justdodagger2.modules.home.HomeActivity;
import com.example.zhiyicx.justdodagger2.modules.register.RegisterActivity;
import com.example.zhiyicx.justdodagger2.widget.button.LoadingButton;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
import com.example.zhiyicx.justdodagger2.widget.edittext.PasswordEditText;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class LoginFragment extends BaseFragment<LoginConstract.Presenter> implements LoginConstract.View {
    @BindView(R.id.login)
    LoadingButton login;
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

        login.setEnabled(false);

        Observable.combineLatest(
                RxTextView.textChanges(etLoginPhone).skip(1),
                RxTextView.textChanges(etLoginPassword).skip(1),
                (charSequence, charSequence2) -> !TextUtils.isEmpty(charSequence)
                        && !TextUtils.isEmpty(charSequence2))
                .subscribe(aBoolean -> login.setEnabled(aBoolean));

        RxView.clicks(login)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> {
                    showLoading();
                    Observable.timer(2000, TimeUnit.MILLISECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aLong -> mPresenter.login(etLoginPhone.getText().toString(), etLoginPassword.getText().toString()));
                });

        RxView.clicks(mRegister)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> {
                    startActivity(new Intent(getActivity(), RegisterActivity.class));
                    getActivity().finish();
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
        showSnackSuccessMessage("登陆成功");
        Observable.timer(200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> startActivity(new Intent(getActivity(), HomeActivity.class)));

    }

    @Override
    protected CharSequence setCenterTitle() {
        return "登陆";
    }
}
