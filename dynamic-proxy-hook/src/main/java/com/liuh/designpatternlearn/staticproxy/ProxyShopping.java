package com.liuh.designpatternlearn.staticproxy;

import com.liuh.designpatternlearn.Shopping;

/**
 * Created by huan on 2018/4/15.
 * 我们自己没有时间买，就找了一个代理，让他帮我们买。
 * 感觉像是对某个对象的功能进行了增强.
 * 这个代理坑了我们的钱，还掉包了我们的货
 */

public class ProxyShopping implements Shopping {

    Shopping base;

    public ProxyShopping(Shopping base) {
        this.base = base;
    }

    @Override
    public Object[] doShopping(long money) {

        //先黑点钱（修改输入参数）
        long readCost = (long) (money * 0.5);
        System.out.println(String.format("代理实际花了%s块钱", readCost));

        //帮忙买东西
        Object[] things = base.doShopping(readCost);

        //偷梁换柱（修改返回值）
        if (things != null && things.length > 1) {
            things[0] = "这个是被代理掉包的东西";
        }
//        System.out.println(Arrays.toString(things));
        return things;
    }
}
