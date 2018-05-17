package com.ndk.jni.jniprojectdemo;

/**
 * Created on 2018/5/16.
 *
 * @author liuj
 * @remarks java类 提供native方法
 * com.ndk.jni.jniprojectdemo.JniJava
 * com.ndk.jni.jniprojectdemo.JniJava
 */

public class JniJava {
    static {
        System.loadLibrary("LJPriject");
    }
    /**
     *@data  2018/5/16
     *@author liujing
     *@describe java层,通过该方法从C层获取到一个字符串
     */
    public native String getCString();
}
