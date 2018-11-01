package com.liuh.ChainOfResponse;

/**
 * Date: 2018/11/1 09:44
 * Description: 解决奇数的问题
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}
