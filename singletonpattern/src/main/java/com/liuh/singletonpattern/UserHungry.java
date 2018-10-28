package com.liuh.singletonpattern;

/**
 * 单例模式   饿汉式
 * <p>
 * 类一旦加载，就实例化类的对象
 * <p>
 * 在这种情况下，当我们没有加载此类，但是没有使用到它的实例对象时，内存中的它的实例对象就是无用的创建
 * <p>
 * 不会存在线程同步问题
 */
public class UserHungry {

    private static UserHungry mUser = new UserHungry();


    private UserHungry() {
    }

    public static UserHungry getInstance() {
        return mUser;
    }

}
