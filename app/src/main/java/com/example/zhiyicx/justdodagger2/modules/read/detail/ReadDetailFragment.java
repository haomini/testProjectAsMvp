package com.example.zhiyicx.justdodagger2.modules.read.detail;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhiyicx.justdodagger2.R;
import com.example.zhiyicx.justdodagger2.base.BaseFragment;

import butterknife.BindView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/31
 * @Contact 605626708@qq.com
 */

public class ReadDetailFragment extends BaseFragment {

    @BindView(R.id.web)
    WebView web;
    private String text;

    public static ReadDetailFragment newInstance(Bundle bundle) {
        ReadDetailFragment fragment = new ReadDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView() {
        text = getArguments().getString("web");
    }

    @Override
    protected void initData() {

        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        web.loadUrl(text);
        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                web.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected int getBodyLayout() {
        return R.layout.fragment_read_detail;
    }


    public void onBackPressed(){
        if(web.canGoBack()){
            web.goBack();
        }else{
            getActivity().finish();
        }
    }
}
