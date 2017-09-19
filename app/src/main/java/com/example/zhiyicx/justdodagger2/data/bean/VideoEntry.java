package com.example.zhiyicx.justdodagger2.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/19
 * @Contact 605626708@qq.com
 */

@Entity
public class VideoEntry {
    private String name;
    private String path;
    private String length;
    private long duration;
    private String createdTime;
    private String updateTime;

    @Generated(hash = 612879807)
    public VideoEntry(String name, String path, String length, long duration,
            String createdTime, String updateTime) {
        this.name = name;
        this.path = path;
        this.length = length;
        this.duration = duration;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }

    @Generated(hash = 1452415894)
    public VideoEntry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
