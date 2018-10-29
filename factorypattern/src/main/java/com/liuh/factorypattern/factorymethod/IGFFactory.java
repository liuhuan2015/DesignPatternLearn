package com.liuh.factorypattern.factorymethod;

/**
 * Date: 2018/10/29 10:07
 * Description:
 * <p>
 * 在简单工厂模式已经写好的情况下，我又有了一个想要一个云南妹子的要求，这时enum(GFType)要改，GFFactory要增加case。
 * <p>
 * 工厂方法模式：给用户一个接口，用户想创建哪里的就创建哪里的
 * <p>
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到了其子类。UML图见 uml_factory_method.webp。
 *
 * 实际中的场景意义：如果需要新的妹子，只需新建一个工厂重载工厂方法以创建新的妹子。
 */
public interface IGFFactory {
    BaseGF createGF();
}
