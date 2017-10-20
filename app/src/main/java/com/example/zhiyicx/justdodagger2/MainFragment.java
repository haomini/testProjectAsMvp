package com.example.zhiyicx.justdodagger2;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhiyicx.justdodagger2.base.BaseFragment;
import com.example.zhiyicx.justdodagger2.widget.edittext.DeleteEditText;
import com.example.zhiyicx.justdodagger2.widget.edittext.EditTextAddWrapper;
import com.example.zhiyicx.justdodagger2.widget.linear.TagLinearLayout;
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
    @BindView(R.id.vvvvv)
    TagLinearLayout mTagLinearLayout;



    private EditTextAddWrapper<DeleteEditText> wrapper;

    @Override
    protected void initView() {

        RxView.clicks(show)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> mPresenter.doA());

        RxView.clicks(show2)
                .compose(this.bindToLifecycle())
                .subscribe(aVoid -> showSnackSuccessMessage(wrapper.getText()));

        mTagLinearLayout.setTextSize(17);
        mTagLinearLayout.setArrays("你试试", "nishishi",/* "try only", "NISH", "你看看嫩遂宁市",*/ "不一样的吗");
        mTagLinearLayout.setTagClickedListener((v, position) -> showSnackSuccessMessage(((TextView) v).getText()));
    }

    @Override
    protected void initData() {
        mPresenter.doA();
        wrapper = new EditTextAddWrapper(del, "123", 3, 4);
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
        return "真水狗儿";
    }

    @OnClick(R.id.kankan)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), ThinkActivity.class));
    }
}
