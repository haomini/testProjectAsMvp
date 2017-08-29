package com.example.zhiyicx.justdodagger2.modules.register;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.base.config.ConstantConfig;
import com.example.zhiyicx.justdodagger2.widget.button.LoadingButton;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by haomini on 2017/8/29.
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
    public void registerSuccess() {

    }

    @Override
    protected void initView() {
        RxView.clicks(btRegistRegist)
                .throttleFirst(ConstantConfig.JITTER_SPACING_TIME, TimeUnit.SECONDS)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> {
                    showLoading();
                    btRegistRegist.postDelayed(() -> hideLoading(), 3000);
                });
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
}
