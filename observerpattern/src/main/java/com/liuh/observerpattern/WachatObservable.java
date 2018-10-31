package com.liuh.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2018/10/31 10:30
 * Description: 具体的被观察者
 */
public class WachatObservable implements Observable {

    // 这个List集合的泛型参数为Observer类型，设计原则：变相接口编程而不是面向实现编程
    private List<Observer> list;

    private String message;

    public WachatObservable() {
        this.list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {

        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;

        System.out.println("收到消息：" + s);

        // 消息更新，通知所有观察者
        notifyObserver();
    }

}
