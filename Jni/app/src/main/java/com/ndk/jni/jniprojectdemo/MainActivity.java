package com.ndk.jni.jniprojectdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private JniJava jniJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jniJava = new JniJava();
        String cString = jniJava.getCString();
        Log.e(TAG, "onCreate: 调用jni 获取到的字符串=="+ cString);
    }
}
