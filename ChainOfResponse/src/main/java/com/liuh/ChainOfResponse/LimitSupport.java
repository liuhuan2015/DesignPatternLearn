package com.liuh.ChainOfResponse;

/**
 * Date: 2018/11/1 09:41
 * Description: 解决指定范围内的问题
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }

        return false;
    }
}
