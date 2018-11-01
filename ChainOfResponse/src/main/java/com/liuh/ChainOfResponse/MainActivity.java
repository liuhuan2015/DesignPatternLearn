package com.liuh.ChainOfResponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 定义了一个责任链，将几个Support对象连接在一起，组成一条责任链，然后去处理问题。
 * <p>
 * 在责任链模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，以此类推。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Support a = new NoSupport("A");
        Support b = new LimitSupport("B", 100);
        Support c = new SpecialSupport("C", 111);

        Support d = new LimitSupport("D", 200);
        Support e = new OddSupport("E");
        Support f = new LimitSupport("F", 300);

        a.setNext(b).setNext(c).setNext(d).setNext(e).setNext(f);

        for (int i = 0; i < 500; i += 33) {
            a.support(new Trouble(i));
        }

    }
}
