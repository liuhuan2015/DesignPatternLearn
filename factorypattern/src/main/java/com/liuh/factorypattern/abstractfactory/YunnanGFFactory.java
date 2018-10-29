package com.liuh.factorypattern.abstractfactory;

/**
 * Date: 2018/10/29 10:17
 * Description:
 */
public class YunnanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new YunnanGF();
    }

    @Override
    public IGFFather createGFFather() {
        return new YunnanGFFather();
    }
}
