package com.example.zhiyicx.justdodagger2.base;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;

import com.example.zhiyicx.justdodagger2.base.dagger.app.AppComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.app.AppModule;
import com.example.zhiyicx.justdodagger2.base.dagger.app.DaggerAppComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.app.GreenDaoModule;
import com.example.zhiyicx.justdodagger2.base.dagger.app.HttpClientModule;
import com.example.zhiyicx.justdodagger2.base.dagger.app.SingleDaoModule;
import com.example.zhiyicx.justdodagger2.data.bean.DaoMaster;
import com.example.zhiyicx.justdodagger2.data.bean.DaoSession;
import com.tencent.bugly.crashreport.CrashReport;

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

    public static final String DBName = "wake.db";
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
        initSkin();
        initAppComponent();
        initDb();
        initBugly();
    }

    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "f51386d25d", true);
    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper  = new DaoMaster.DevOpenHelper(this, DBName);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
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

    public void initAppComponent() {
        AppComponent mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpClientModule(new HttpClientModule())
                .serviceModule(new ServiceModule())
                .greenDaoModule(new GreenDaoModule())
                .singleDaoModule(new SingleDaoModule())
                .build();

        AppComponentHolder.setAppComponent(mAppComponent);
        mAppComponent.inject(this);
    }

    public static class AppComponentHolder {

        private static AppComponent mAppComponent;

        public static AppComponent getAppComponent() {
            return mAppComponent;
        }

        public static void setAppComponent(AppComponent appComponent) {
            mAppComponent = appComponent;
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static DaoSession getDaoSession(){
        return mDaoSession;
    }
}
