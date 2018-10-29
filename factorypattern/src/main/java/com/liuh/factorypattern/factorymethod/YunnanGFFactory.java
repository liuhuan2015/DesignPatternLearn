package com.liuh.factorypattern.factorymethod;

/**
 * Date: 2018/10/29 10:17
 * Description:
 */
public class YunnanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new YunnanGF();
    }
}
