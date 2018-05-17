package com.jni.project.jniproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.ndk.jni.jniprojectdemo.JniJava;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JniJava jniJava = new JniJava();
       String string = jniJava.getCString();
        Log.e(TAG, "onCreate: "+string);
    }
}
