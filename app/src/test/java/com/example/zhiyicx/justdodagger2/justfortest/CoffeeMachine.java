package com.example.zhiyicx.justdodagger2.justfortest;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/9/20
 * @Contact 605626708@qq.com
 */

public class CoffeeMachine{
    public CoffeeMaker mCoffeeMaker;

    @Inject
    public CoffeeMachine(CoffeeMaker maker) {
        this.mCoffeeMaker = maker;
    }

    // set
    public void setCoffeeMaker(CoffeeMaker coffeeMaker) {
        mCoffeeMaker = coffeeMaker;
    }

    public void makeCoffee(){
        mCoffeeMaker.make();
    }
}
