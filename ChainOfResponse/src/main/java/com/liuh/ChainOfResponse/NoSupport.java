package com.liuh.ChainOfResponse;

/**
 * Date: 2018/11/1 09:37
 * Description: 永远不解决问题的类
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
