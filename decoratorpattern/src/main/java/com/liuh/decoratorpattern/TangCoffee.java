package com.liuh.decoratorpattern;

/**
 * Date: 2018/10/30 09:03
 * Description:
 */
public class TangCoffee implements Coffee {

    private Coffee mCoffee;

    public TangCoffee() {
    }

    public TangCoffee(Coffee mCoffee) {
        this.mCoffee = mCoffee;
    }

    @Override
    public void kouwei() {
        if (mCoffee != null) {
            mCoffee.kouwei();
        }
        System.out.println("-----加点糖");
    }
}
