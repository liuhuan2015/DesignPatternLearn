package com.liuh.decoratorpattern;

/**
 * Date: 2018/10/30 09:01
 * Description:
 */
public class NaiCoffee implements Coffee {

    private Coffee mCoffee;

    public NaiCoffee() {
    }

    public NaiCoffee(Coffee mCoffee) {
        this.mCoffee = mCoffee;
    }

    @Override
    public void kouwei() {
        if (mCoffee != null) {
            mCoffee.kouwei();
        }
        System.out.println("-----加点牛奶");
    }
}
