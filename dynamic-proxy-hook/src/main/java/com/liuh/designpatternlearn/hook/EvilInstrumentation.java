package com.liuh.designpatternlearn.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by huan on 2018/4/15.
 */

public class EvilInstrumentation extends Instrumentation {

    private static final String TAG = "EvilInstrumentation";

    //Activity中的原始的对象，保存起来
    Instrumentation mBase;

    public EvilInstrumentation(Instrumentation mBase) {
        this.mBase = mBase;
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token,
                                            Activity target, Intent intent, int requestCode,
                                            Bundle options) {
        //Hook之前，xxx到此一游
        Log.e(TAG, "\n执行了startActivity，参数如下：\n" + "who=" + who + ",contextThread=" + contextThread
                + ",token=" + token + ",target=" + target + ",intent=" + intent + ",requestCode=" + requestCode
                + ",options=" + options);
        //开始调用原始的方法，调不调随你，但是如果不调用的话，所有的startActivity就会都失效。
        //由于这个方法是隐藏的，因此需要使用反射调用；首先找到这个方法
        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod(
                    "execStartActivity",
                    Context.class, IBinder.class, IBinder.class, Activity.class,
                    Intent.class, int.class, Bundle.class);
            return (ActivityResult) execStartActivity.invoke(mBase, who, contextThread, token, target,
                    intent, requestCode, options);

        } catch (Exception e) {
            //被某个rom修改了，需要手动适配
            e.printStackTrace();
            throw new RuntimeException("do not support!!! pls adapt it");
        }
    }

}
