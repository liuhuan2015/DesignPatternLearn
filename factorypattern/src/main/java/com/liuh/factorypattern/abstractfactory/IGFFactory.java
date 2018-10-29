package com.liuh.factorypattern.abstractfactory;

/**
 * Date: 2018/10/29 10:07
 * Description:
 * <p>
 * 在工厂方法模式写好的情况下，又有了新的需求，比如：有一天我想和云南妹子结婚了，才发现好像还没有见过妹子的父母
 * <p>
 * <p>
 * 抽象工厂模式：提供一个创建一系列相关或者相互依赖对象的接口，而无需指定他们具体的类。UML图见 uml_abstract_factory.webp。
 *
 * 附上一句作者的原话：就这样，我和我的云南妹子去见了她父母，然后过上了幸福的生活.
 */
public interface IGFFactory {
    BaseGF createGF();

    IGFFather createGFFather();
}
