package com.liuh.designpatternlearn;

/**
 * Created by huan on 2018/4/15.
 * 购物接口的一个原始的实现，可以理解为亲自，直接去商店购物
 */

public class ShoppingImpl implements Shopping {
    @Override
    public Object[] doShopping(long money) {
        System.out.println("逛商场，逛大街，买买买！！");
        System.out.println(String.format("花了%s块钱", money));
        return new Object[]{"鞋子", "衣服", "零食"};
    }
}
