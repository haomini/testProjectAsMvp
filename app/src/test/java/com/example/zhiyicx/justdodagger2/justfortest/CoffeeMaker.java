package com.example.zhiyicx.justdodagger2.justfortest;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/20
 * @Contact 605626708@qq.com
 */

public class CoffeeMaker implements CoffeeIterface {

    @Inject
    public CoffeeMaker() {
    }

    @Override
    public void make() {
        System.out.println("CofferMaker tend to make coffee");
    }
}
