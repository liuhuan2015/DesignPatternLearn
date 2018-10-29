package com.liuh.factorypattern.factorymethod;

/**
 * Date: 2018/10/29 10:14
 * Description:
 */
public class SichuanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new SichuanGF();
    }
}
