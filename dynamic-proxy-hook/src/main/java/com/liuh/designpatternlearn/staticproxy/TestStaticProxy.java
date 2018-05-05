package com.liuh.designpatternlearn.staticproxy;

import com.liuh.designpatternlearn.ShoppingImpl;

import java.util.Arrays;

/**
 * Created by huan on 2018/5/5.
 * 对静态代理的测试
 * <p>
 * 传统的静态代理模式需要为每一个被代理的类写一个代理类，如果需要被代理的类有几百个岂不是要被累死。
 * 为了更优雅的实现代理模式，JDK提供了动态代理方式，可以简单理解为JVM可以在运行时帮我们动态生成一系列的代理类，
 * 这样我们就不需要手写每一个静态的代理类了。
 */

public class TestStaticProxy {

    public static void main(String[] args) {
        ProxyShopping proxyShopping = new ProxyShopping(new ShoppingImpl());
        Object[] objs = proxyShopping.doShopping(100);
        System.out.println("我交给顾客的物品:" + Arrays.asList(objs).toString());
    }
}
