package com.liuh.designpatternlearn.staticproxy;

import com.liuh.designpatternlearn.Shopping;

import java.util.Arrays;

/**
 * Created by huan on 2018/5/5.
 * 有时候我们自己没有时间亲自去买东西，于是我们找了个代理帮我们购买
 * <p>
 * 这个代理呢，坑了我们的钱，还掉包了我们的东西
 */

public class ProxyShopping implements Shopping {

    Shopping base;

    public ProxyShopping(Shopping base) {
        this.base = base;
    }

    @Override
    public Object[] doShopping(long money) {

        System.out.println(String.format("我收了顾客%s块钱", money));

        //先黑点钱
        long readCost = (long) (money * 0.5);

        System.out.println(String.format("但是我实际花了%s块钱，我去买东西了", readCost));

        //帮忙买东西
        Object[] things = base.doShopping(readCost);

        System.out.println("我买到了" + Arrays.asList(things).toString());

        if (things != null && things.length > 0) {
            things[0] = "被掉包的东西";
        }
        return things;
    }
}
