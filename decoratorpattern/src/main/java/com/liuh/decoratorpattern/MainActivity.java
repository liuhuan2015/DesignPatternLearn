package com.liuh.decoratorpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 加糖咖啡
     */
    public void fun1() {

        TangCoffee tangCoffee = new TangCoffee();
        tangCoffee.kouwei();
    }

    /**
     * 加糖加牛奶
     */
    public void fun2() {
        TangCoffee tangCoffee = new TangCoffee();
//        tangCoffee.kouwei();

        NaiCoffee naiCoffee = new NaiCoffee(tangCoffee);
        naiCoffee.kouwei();
    }

    /**
     * 加糖加奶加盐
     */
    public void fun3() {
        TangCoffee tangCoffee = new TangCoffee();
//        tangCoffee.kouwei();

        NaiCoffee naiCoffee = new NaiCoffee(tangCoffee);
//        naiCoffee.kouwei();

        YanCoffee yanCoffee = new YanCoffee(naiCoffee);
        yanCoffee.kouwei();


    }


}
