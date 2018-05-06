package com.liuh.designpatternlearn.hook_activity_startActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by huan on 2018/5/5.
 */

public class EvilActivityInstrumentation extends Instrumentation {

    private static final String TAG = "EvilActivity";

    private Instrumentation instrumentation;

    public EvilActivityInstrumentation(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
        Log.e("--------------", "程序走到了这里 EvilActivityInstrumentation");
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target,
                                            Intent intent, int requestCode, Bundle options) {

        // Hook之前, XXX到此一游!
        Log.e(TAG, "\n执行了startActivity(Activity), 参数如下: \n" + "who = [" + who + "], " +
                "\ncontextThread = [" + contextThread + "], \ntoken = [" + token + "], " +
                "\ntarget = [" + target + "], \nintent = [" + intent +
                "], \nrequestCode = [" + requestCode + "], \noptions = [" + options + "]");

        //开始调用原始的方法，调不调用随你，但是不调用的话，所有的startActivity都会失效，
        //由于这个方法是隐藏的，因此需要使用反射调用；首先找到这个方法

        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod("execStartActivity",
                    Context.class,
                    IBinder.class,
                    IBinder.class,
                    Activity.class,
                    Intent.class,
                    int.class,
                    Bundle.class);

            execStartActivity.setAccessible(true);

            return (ActivityResult) execStartActivity.invoke(instrumentation, who, contextThread, token, target, intent, requestCode, options);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // 某该死的rom修改了  需要手动适配
            throw new RuntimeException("do not support!!! pls adapt it");
        }
        return null;
    }

}
