package com.liuh.designpatternlearn;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liuh.designpatternlearn.hook_activity_startActivity.HookActivityHelper;

/**
 * 我们知道，代理有比原始对象更强大的能力，比如飞到国外去买东西，坑钱坑货等。那么很自然，如果我们自己创建代理对象，
 * 然后把原始对象替换成我们的代理对象，那么就可以在这个代理对象中为所欲为了：修改参数，替换返回值等。
 * 这种使用代理对象替换原始对象，然后做一些额外操作的行为，我们称之为Hook。
 * <p>
 * 这个module展示了静态代理，动态代理。以及使用代理模式分别Hook Context.startActivity(...)和Hook Activity.startActivity(...)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        try {
            HookActivityHelper.attachContext(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button tv = new Button(this);
        tv.setText("测试界面");

        setContentView(tv);

        ActivityManager am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("http://www.baidu.com"));

                //注意这里是使用的ApplicationContext启动的Activity
                //因为Activity对象的startActivity使用的并不是ContextImpl的mInstrumentation
                //而是自己的mInstrumentation,如果你需要这样，可以自己Hook
                //比较简单，直接替换这个Activity的此字段即可
//                getApplicationContext().startActivity(intent);

                startActivity(intent);
            }
        });
    }

    //这个方法在onCreate(...)方法执行前执行
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

        try {
            //在这里进行Hook
            //HookHelper.attachContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
