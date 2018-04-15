package com.liuh.designpatternlearn.staticproxy;

import com.liuh.designpatternlearn.Shopping;
import com.liuh.designpatternlearn.ShoppingImpl;

import java.util.Arrays;

/**
 * Created by huan on 2018/4/15.
 * 静态代理
 */

public class TestStatic {

    public static void main(String[] args) {

        //原始的买家
        Shopping women = new ShoppingImpl();

        //自己去购买
        System.out.println(Arrays.toString(women.doShopping(100)));

        System.out.println("----------------------------------------------");

        //换成找个代理去购买
        women = new ProxyShopping(women);
        System.out.println(Arrays.toString(women.doShopping(100)));

    }
}
