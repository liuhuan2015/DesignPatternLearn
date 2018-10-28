package com.liuh.singletonpattern;

/**
 * 单例模式 懒汉式
 * <p>
 * 这个可能是 懒汉式 + 线程安全 的一种比较高效率的写法，使用 synchronized 进行代码块同步（同一时刻只能有一个线程执行这个代码块）
 */
public class UserSynchronized {

    private static UserSynchronized mUser;

    private UserSynchronized() {
    }

    public static UserSynchronized getInstance() {

        if (mUser == null) {
            synchronized (UserSynchronized.class) {
                if (mUser == null) {
                    mUser = new UserSynchronized();
                }
            }
        }

        return mUser;
    }

}
