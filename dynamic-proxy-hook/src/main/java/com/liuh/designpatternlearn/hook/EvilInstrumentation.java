package com.liuh.designpatternlearn.hook;

import android.app.Instrumentation;

/**
 * Created by huan on 2018/4/15.
 */

public class EvilInstrumentation extends Instrumentation {

    private static final String TAG = "EvilInstrumentation";

    //Activity中的原始的对象，保存起来
    Instrumentation mBase;




}
