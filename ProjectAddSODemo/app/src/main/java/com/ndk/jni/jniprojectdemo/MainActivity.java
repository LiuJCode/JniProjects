package com.ndk.jni.jniprojectdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
    private JniJava jniJava;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jniJava = new JniJava();
        String cString = jniJava.getCString();
        Log.e(TAG, "onCreate: "+ cString );
    }
}
