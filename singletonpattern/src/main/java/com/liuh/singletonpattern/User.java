package com.liuh.singletonpattern;

/**
 * 一种简单的单例模式的写法：构造方法私有，对外提供一个获取当前类对象的一个 public 方法
 * <p>
 * 项目中好像用的比较多的形式就是这一种
 * <p>
 * 属于懒汉式，只有在要使用到类的实例对象时，才进行 new 操作
 * <p>
 * 会存在线程同步问题
 */
public class User {

    private static User mUser;

    private User() {
    }

    public static User getInstance() {
        if (mUser == null) {
            mUser = new User();
        }

        return mUser;
    }

}
