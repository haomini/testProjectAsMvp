package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.data.bean.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/8/30
 * @Contact 605626708@qq.com
 */

public class VideoFactory {


    public static List<Video> getVideos(int limit) {
        List<Video> list = new ArrayList<>();

        Video video = new Video();
        video.setName("汤姆猫历险记");
        video.setUrl("https://media.w3.org/2010/05/sintel/trailer.mp4");

        list.add(video);

        Video video0 = new Video();
        video0.setName("大白兔");
        video0.setUrl("http://www.w3school.com.cn/example/html5/mov_bbb.mp4");

        list.add(video0);

        Video video1 = new Video();
        video1.setName("湖光三色");
        video1.setUrl("http://211.162.138.34/mp4files/4100000001F483C8/clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

        list.add(video1);

        Video video2 = new Video();
        video2.setName("经典致敬");
        video2.setUrl("http://baobab.wdjcdn.com/14564977406580.mp4");

        list.add(video2);

        Video video3 = new Video();
        video3.setName("我也不知道什么名字");
        video3.setUrl("http://7xse1z.com1.z0.glb.clouddn.com/1491813192");

        list.add(video3);

        Video video4 = new Video();
        video4.setName("汤姆猫历险记");
        video4.setUrl("https://media.w3.org/2010/05/sintel/trailer.mp4");

        list.add(video4);

        Video video5 = new Video();
        video5.setName("汤姆猫历险记");
        video5.setUrl("https://media.w3.org/2010/05/sintel/trailer.mp4");

        list.add(video5);
        return list;
    }
}