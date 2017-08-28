package com.example.zhiyicx.justdodagger2.base;

import android.app.Application;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/28
 * @Contact 605626708@qq.com
 */

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
        initSkin();
    }

    protected void initSkin() {
        SkinCompatManager.withoutActivity(this)                 // 基础控件换肤初始化
//              .addInflater(new SkinConstraintViewInflater())  // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinMaterialViewInflater())    // material design 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())        // CardView v7 控件换肤初始化[可选]
                .loadSkin();
    }

    public static BaseApplication getApp() {
        return application;
    }
}
