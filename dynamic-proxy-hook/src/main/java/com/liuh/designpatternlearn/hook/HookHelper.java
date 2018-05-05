package com.liuh.designpatternlearn.hook;

import android.app.Instrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by huan on 2018/5/5.
 * startActivity有两种流程，一种是Context.startActivity(...),一种是Activity.startActivity(...),
 * 两者的调用链是不一样的
 * Context的实现实际上是ContextImpl的，我们看ContextImpl中startActivity的实现，其中有一段代码如下：
 * mMainThread.getInstrumentation().execStartActivity(
 * getOuterContext(), mMainThread.getApplicationThread(), null,
 * (Activity) null, intent, -1, options);
 * 因为mMainThread是主线程，而主线程一个进程只有一个，因此这是一个良好的hook点
 * 我们写一个Instrumentation的代理类，在其中执行execStartActivity之前打印一个我们的Log
 */

public class HookHelper {

    public static void attachContext() throws Exception {

        //先获取到当前的ActivityThread对象
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");
        Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);

        //这个方法是静态的，所以对象实例可以为null,通过ActivityThread的静态方法currentActivityThread拿到currentActivityThread对象
        Object currentActivityThread = currentActivityThreadMethod.invoke(null);

        //拿到原始的Instrumentation对象实例
        Field mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        mInstrumentationField.setAccessible(true);
        Instrumentation mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);

        //创建代理对象，将原始的对象实例作为参数传入
        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);

        //偷梁换柱，使用反射把系统自己的Instrumentation替换成我们编写的Instrumentation
        mInstrumentationField.set(currentActivityThread, evilInstrumentation);

    }

}
