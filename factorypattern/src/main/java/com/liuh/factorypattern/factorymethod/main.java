package com.liuh.factorypattern.factorymethod;

/**
 * Date: 2018/10/29 10:18
 * Description:
 */
public class main {

    public static void main(String[] args) {
        IGFFactory yunnanGFFactory = new YunnanGFFactory();
        BaseGF yunnanGf = yunnanGFFactory.createGF();

        yunnanGf.eatFood();
        yunnanGf.shopping();
    }

}
