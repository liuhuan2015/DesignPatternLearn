package com.liuh.factorypattern.abstractfactory;

/**
 * Date: 2018/10/29 10:14
 * Description:
 */
public class SichuanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new SichuanGF();
    }

    @Override
    public IGFFather createGFFather() {
        return new SichuanGFFather();
    }
}
