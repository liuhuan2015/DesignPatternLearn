package com.liuh.observerpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WachatObservable observable = new WachatObservable();

        Observer observer1 = new WachatObserver("张三");
        Observer observer2 = new WachatObserver("李斯");
        Observer observer3 = new WachatObserver("王五");

        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);

        observable.setInfomation("Java 是世界上最好的语言！");

        System.out.println("-----------------华丽分割线------------------");

        observable.unregisterObserver(observer1);

        observable.setInfomation("Python 是世界上最好的语言！");
    }
}
