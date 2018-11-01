package com.liuh.ChainOfResponse;

/**
 * Date: 2018/11/1 09:46
 * Description: 解决某个特定数目的问题
 */
public class SpecialSupport extends Support {

    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        }

        return false;
    }
}
