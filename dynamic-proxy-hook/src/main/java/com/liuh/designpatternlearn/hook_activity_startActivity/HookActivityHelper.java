package com.liuh.designpatternlearn.hook_activity_startActivity;

import android.app.Activity;
import android.app.Instrumentation;

import java.lang.reflect.Field;

/**
 * Created by huan on 2018/5/6.
 */

public class HookActivityHelper {

    public static void attachContext(Activity activity) throws Exception {

        Class<?> currentActivity = Activity.class;

        //获取Activity类的实例对象
//        Object activityObj = currentActivity.newInstance();

        Field instrumentationField = currentActivity.getDeclaredField("mInstrumentation");

        instrumentationField.setAccessible(true);

        //拿到Activity类的实例对象中的Instrumentation属性值(拿到传进来的Activity对象中的Instrumentation属性值)
        Instrumentation mInstrumentation = (Instrumentation) instrumentationField.get(activity);

        Instrumentation customInstrumentation = new EvilActivityInstrumentation(mInstrumentation);
        instrumentationField.set(activity, customInstrumentation);
    }

}
