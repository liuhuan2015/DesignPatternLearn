package com.liuh.observerpattern;

/**
 * Date: 2018/10/31 10:16
 * Description: 抽象的被观察者
 */
public interface Observable {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObserver();


}
