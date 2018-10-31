package com.liuh.observerpattern;

/**
 * Date: 2018/10/31 14:56
 * Description: 具体的观察者
 */
public class WachatObserver implements Observer {

    private String name;
    private String message;

    public WachatObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        this.message = msg;
        read();
    }

    private void read() {
        System.out.println(name + " 收到消息：" + message);
    }
}
