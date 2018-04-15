package com.liuh.designpatternlearn.dynamicproxy;

import com.liuh.designpatternlearn.Shopping;
import com.liuh.designpatternlearn.ShoppingImpl;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by huan on 2018/4/15.
 * 动态代理
 */

public class TestDynamic {

    public static void main(String[] args) {
        Shopping women = new ShoppingImpl();

        //正常购物（自己去购买）
        System.out.println(Arrays.toString(women.doShopping(100)));

        System.out.println("----------------------------------------------");

        //招代理(动态代理)
        women = (Shopping) Proxy.newProxyInstance(Shopping.class.getClassLoader(),
                women.getClass().getInterfaces(), new ShoppingHandler(women));

        System.out.println(Arrays.toString(women.doShopping(100)));
    }
}
