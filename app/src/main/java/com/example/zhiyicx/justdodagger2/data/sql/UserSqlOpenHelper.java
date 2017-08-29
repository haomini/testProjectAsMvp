package com.example.zhiyicx.justdodagger2.data.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class UserSqlOpenHelper extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String DATA_NAME = "user.db";
    public final static String TABLE_NAME = "User";

    // id自增
    public final static String _ID = "_id";
    // 用户名
    public final static String _Name = "_name";
    // 密码
    public final static String _PWD = "_pwd";

    //建表与句
    private final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            _ID + " integer primary key autoincrement, " + _Name + " varchar(15) unique, " + _PWD + " varchar(15))";

    public UserSqlOpenHelper(Context context) {
        super(context, DATA_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
