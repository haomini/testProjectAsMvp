package com.example.zhiyicx.justdodagger2.modules.video;

import com.example.zhiyicx.justdodagger2.base.InjectComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.app.AppComponent;
import com.example.zhiyicx.justdodagger2.base.dagger.scope.PerFragment;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/6
 * @Contact 605626708@qq.com
 */

@PerFragment
@Component(dependencies = AppComponent.class, modules = VideoPresenterModule.class)
public interface VideoComponent extends InjectComponent<VideoFragment> {
}
