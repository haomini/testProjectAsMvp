package com.example.zhiyicx.justdodagger2.modules.register;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.base.config.ConstantConfig;
import com.example.zhiyicx.justdodagger2.modules.home.HomeActivity;
import com.example.zhiyicx.justdodagger2.widget.button.LoadingButton;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
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


public class RegisterFragment extends BaseFragment<RegisterConstract.Presenter> implements RegisterConstract.View {
    @BindView(R.id.et_regist_username)
    DeleteEditText etRegistUsername;
    @BindView(R.id.et_regist_pwd)
    DeleteEditText etRegistPwd;
    @BindView(R.id.ll_register_pwd)
    LinearLayout llRegisterPwd;
    @BindView(R.id.et_regist_pwd_sure)
    DeleteEditText etRegistPwdSure;
    @BindView(R.id.tv_error_tip)
    TextView tvErrorTip;
    @BindView(R.id.bt_regist_regist)
    LoadingButton btRegistRegist;

    @Override
    protected void initView() {

        btRegistRegist.setEnabled(false);

        RxView.clicks(btRegistRegist)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .filter(aVoid -> {
                    boolean isEquals = etRegistPwdSure.getText().toString().equals(etRegistPwd.getText().toString());
                    if (!isEquals)
                        showSnackErrorMessage("两次输入的密码不一致，请检查!");
                    return isEquals;
                })
                .subscribe(aVoid -> {
                    showLoading();
                    Observable.timer(2000, TimeUnit.MILLISECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(aLong -> mPresenter.register(etRegistUsername.getText().toString(), etRegistPwd.getText().toString()));
                });


        Observable.combineLatest(
                RxTextView.textChanges(etRegistUsername).skip(1),
                RxTextView.textChanges(etRegistPwd).skip(1),
                RxTextView.textChanges(etRegistPwdSure).skip(1),
                (charSequence, charSequence2, charSequence3) -> !TextUtils.isEmpty(charSequence)
                        && !TextUtils.isEmpty(charSequence2)
                        && !TextUtils.isEmpty(charSequence3))
                .subscribe(aBoolean -> btRegistRegist.setEnabled(aBoolean));

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "注册";
    }

    @Override
    public void showLoading() {
        btRegistRegist.setEnabled(false);
        btRegistRegist.handleAnimation();
    }

    @Override
    public void hideLoading() {
        btRegistRegist.setEnabled(false);
        btRegistRegist.hideAnimation();
    }

    @Override
    public void showSnackErrorMessage(CharSequence s) {
        tvErrorTip.setText(s);
    }

    @Override
    public void registerSuccess() {
        showSnackSuccessMessage("注册成功,请登录");
        startActivity(new Intent(getActivity(), HomeActivity.class));
        getActivity().finish();
        Observable.timer(200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> getActivity().finish());
    }
}
