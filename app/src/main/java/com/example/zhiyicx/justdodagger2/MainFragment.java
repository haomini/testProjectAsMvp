package com.example.zhiyicx.justdodagger2;

import android.content.Intent;
import android.widget.Button;

import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
import com.example.zhiyicx.justdodagger2.widget.edittext.EditTextAddWrapper;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

public class MainFragment extends BaseFragment<Contract.Presenter> implements Contract.View {

    @BindView(R.id.show)
    Button show;
    @BindView(R.id.show_2)
    Button show2;
    @BindView(R.id.del)
    DeleteEditText del;

    private EditTextAddWrapper<DeleteEditText> wrapper;

    @Override
    protected void initView() {

        RxView.clicks(show)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> mPresenter.ibpToast());

        RxView.clicks(show2)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> showSnackSuccessMessage(wrapper.getText()));
    }

    @Override
    protected void initData() {
        mPresenter.doA();

        wrapper = new EditTextAddWrapper<>(del, " ", 5, 5);
        wrapper.setText("19213412312");
    }

    public void doShowSnack() {
        showSnackErrorMessage(wrapper.getFormatedText());
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected boolean useToolbar() {
        return true;
    }

    @Override
    protected boolean useToolbarDivider() {
        return true;
    }

    @Override
    protected boolean isLastFragment() {
        return false;
    }

    @Override
    protected CharSequence setCenterTitle() {
        return "我愛你";
    }

    @OnClick(R.id.kankan)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), ThinkActivity.class));
    }
}
