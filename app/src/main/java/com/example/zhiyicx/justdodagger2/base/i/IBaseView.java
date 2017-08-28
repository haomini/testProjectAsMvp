package com.example.zhiyicx.justdodagger2.base.i;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/28
 * @Contact 605626708@qq.com
 */

public interface IBaseView<T extends IBasePresenter> {

    /**
     * 设置presenter
     *
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * 显示错误信息
     *
     * @param s
     */
    void showSnackErrorMessage(CharSequence s);

    /**
     * 显示正确信息
     *
     * @param s
     */
    void showSnackSuccessMessage(CharSequence s);

    /**
     * 显示加载信息
     *
     * @param s
     */
    void showSnackLoadingMessage(CharSequence s);
}
