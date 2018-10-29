package com.liuh.factorypattern.simplefactory;

/**
 * Date: 2018/10/29 09:50
 * Description:
 * <p>
 * 简单工厂模式：专门定义一个类用来负责创建其它类的实例，被创建的实例通常都具有共同的父类。UML图见 uml_simple_factory.webp。
 */
public class GFFactory {

    public static BaseGF createGF(GFType gfType) {

        switch (gfType) {
            case SI_CHUAN:
                return new SichuanGF();
            case SHAN_DONG:
                return new ShandongGF();
            default:
            case HE_NAN:
                return new HenanGF();
        }

    }

}
