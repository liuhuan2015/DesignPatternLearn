package com.liuh.designpatternlearn;

/**
 * Created by huan on 2018/5/5.
 * 对购物接口最原始的实现，可以理解为亲自，直接去商店购物
 */

public class ShoppingImpl implements Shopping {
    @Override
    public Object[] doShopping(long money) {

        System.out.println("逛淘宝，逛商场，买买买！！");
        System.out.println(String.format("花了%s块钱", money));
        return new Object[]{"鞋子", "衣服", "零食"};

    }
}
