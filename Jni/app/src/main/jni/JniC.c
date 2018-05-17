//
// Created by liuj on 2018/5/16.
// c类 实现某一些复杂功能 供给java层调用
//
#include "com_ndk_jni_jniprojectdemo_JniJava.h"
//返回一个字符串给java层
 jstring  Java_com_ndk_jni_jniprojectdemo_JniJava_getCString
  (JNIEnv * env, jobject object){
    // 注意这里创建的是C文件 所以必须以C语言格式去编写
    return (*env) -> NewStringUTF(env,"我来自C层");

  };

