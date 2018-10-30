package com.liuh.decoratorpattern;

/**
 * Date: 2018/10/30 09:05
 * Description:
 */
public class YanCoffee implements Coffee {

    private Coffee mCoffee;

    public YanCoffee() {
    }

    public YanCoffee(Coffee mCoffee) {
        this.mCoffee = mCoffee;
    }

    @Override
    public void kouwei() {
        if (mCoffee != null) {
            mCoffee.kouwei();
        }
        System.out.println("-----加点盐");
    }
}
