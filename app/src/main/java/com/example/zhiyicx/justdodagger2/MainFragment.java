package com.example.zhiyicx.justdodagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhiyicx.justdodagger2.edittext.DeleteEditText;
import com.example.zhiyicx.justdodagger2.edittext.EditTextBlankWrapper;
import com.example.zhiyicx.justdodagger2.widget.TSnackbar;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/11
 * @Contact 605626708@qq.com
 */

public class MainFragment extends Fragment implements Contract.View {

    Contract.Presenter presenter;
    @BindView(R.id.show)
    Button show;
    Unbinder unbinder;
    @BindView(R.id.show_2)
    Button show2;
    @BindView(R.id.del)
    DeleteEditText del;
    private EditTextBlankWrapper<DeleteEditText> wrapper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, null);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.doA();
        RxView.clicks(show)
                .subscribe(aVoid -> presenter.ibpToast());

        RxView.clicks(show2)
                .subscribe(aVoid -> {
                    TSnackbar snackbar = TSnackbar.make(getView(), "text", TSnackbar.LENGTH_SHORT, TSnackbar.APPEAR_FROM_BOTTOM);
                    View view = snackbar.getView();
                    view.setBackgroundResource(android.R.color.white);
                    snackbar.setAction("this is action", v -> Toast.makeText(getActivity(), "wool", Toast.LENGTH_SHORT).show())
                            .show();
                });

        wrapper = new EditTextBlankWrapper<DeleteEditText>(del, "xxx", 3, 7);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void doShowSnack() {
        TSnackbar snackbar = TSnackbar.make(getView(), "text", TSnackbar.LENGTH_SHORT, TSnackbar.APPEAR_FROM_TOP);
        View view = snackbar.getView();
        view.setBackgroundResource(android.R.color.white);
        snackbar.setAction("this is action", v -> Toast.makeText(getActivity(), "wool", Toast.LENGTH_SHORT).show())
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
