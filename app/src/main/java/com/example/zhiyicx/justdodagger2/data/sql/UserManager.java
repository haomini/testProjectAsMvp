package com.example.zhiyicx.justdodagger2.data.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhiyicx.justdodagger2.base.BaseApplication;
import com.example.zhiyicx.justdodagger2.base.BaseBean;
import com.example.zhiyicx.justdodagger2.data.bean.User;

import static com.example.zhiyicx.justdodagger2.base.BaseSubscriber.SUCCESS;
import static com.example.zhiyicx.justdodagger2.data.sql.UserSqlOpenHelper._Name;
import static com.example.zhiyicx.justdodagger2.data.sql.UserSqlOpenHelper._PWD;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/29
 * @Contact 605626708@qq.com
 */

public class UserManager {
    private static UserManager manager;
    private SQLiteDatabase db;

    private UserManager() {
        db = new UserSqlOpenHelper(BaseApplication.getApp()).getWritableDatabase();
    }

    public static UserManager getInstance() {
        return manager == null ? manager = new UserManager() : manager;
    }

    /**
     * 插入用户
     *
     * @param name
     * @param pwd
     * @return
     */
    public BaseBean insertUser(String name, String pwd) {
        BaseBean result = new BaseBean();
        BaseBean<User> baseBean = queryUser(name);
        if (baseBean.getStatus() == SUCCESS) {
            result.setStatus(User.ERROR_ID);
            result.setReason("用户名已存在");
            return result;
        } else {
            ContentValues values = new ContentValues();
            values.put(_Name, name);
            values.put(_PWD, pwd);
            long rowid = db.insert(UserSqlOpenHelper.TABLE_NAME, null, values);
            if (rowid != User.ERROR_ID) {
                result.setStatus(SUCCESS);
                return result;
            } else {
                result.setStatus(User.ERROR_ID);
                result.setReason("未知原因，请联系管理员检查");
                return result;
            }
        }
    }

    /**
     * @param name
     * @return
     */
    public BaseBean<User> queryUser(String name) {
        BaseBean<User> baseBean = new BaseBean<>();
        Cursor cursor = db.query(UserSqlOpenHelper.TABLE_NAME, null, _Name + "=?", new String[]{name}, null, null, null);
        if (cursor.moveToFirst()) {
            baseBean.setStatus(SUCCESS);
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(UserSqlOpenHelper._ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserSqlOpenHelper._Name)));
            baseBean.setResult(user);
            return baseBean;
        } else {
            baseBean.setStatus(User.ERROR_ID);
            baseBean.setReason("用户名不存在");
            return baseBean;
        }
    }

    /**
     * @param name
     * @return
     */
    public BaseBean<User> queryUserWithPwd(String name, String pwd) {
        BaseBean<User> baseBean = new BaseBean<>();
        Cursor cursor = db.query(UserSqlOpenHelper.TABLE_NAME, null, _Name + "=?", new String[]{name}, null, null, null);
        if (cursor.moveToFirst()) {
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(UserSqlOpenHelper._ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserSqlOpenHelper._Name)));
            user.setPwd(cursor.getString(cursor.getColumnIndex(UserSqlOpenHelper._PWD)));
            if(!pwd.equals(user.getPwd())){
                baseBean.setStatus(-2);
                baseBean.setReason("密码错误");
            }else {
                baseBean.setStatus(SUCCESS);
                baseBean.setResult(user);
            }
            return baseBean;
        } else {
            baseBean.setStatus(User.ERROR_ID);
            baseBean.setReason("用户名不存在");
            return baseBean;
        }
    }
}
