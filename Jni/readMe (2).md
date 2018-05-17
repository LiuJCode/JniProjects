NDK环境配置
1.下载NDK压缩包并且解压到某个目录，在AS中使用SDKmanage更新
2.找到该目录下的build文件，并复制，配置环境变量 path
3.配置项目《local.properties》新增ndk.dir:指向NDK目录,(这一步可以直接选择file->project Structure去设置)
4.配置<gradle.properties>文件，新增 android.deprecatedNdkCompileLease=1526438296267

jni代码编写
1.首先定义java层的native方法,定义的这个方法将会对应C中的实现方法。
2.创建jni目录，创建c文件 ->通过快捷方式生成c头文件
  (2.1).生成头文件意思就是将java中的方法转换成在C中的代码形式.方法有：
        1.在（当前工程目录到java级）目录执行 javah com.ndk.jni.ndkproject.JniJava（含有native方法的类的包名+类名）
         在as中点击底部（terminal）可以进入到执行界面
3.配置动态连接库的名称,在mode的gradle->defaultConfig下增加以下代码
   ndk {
            moduleName "JNITest" //输出的SO文件名称
            abiFilters "armeabi", "armeabi-v7a", "x86"//指定cpu的类型
        }
4.加载动态连接库,在编写native方法类中新增：
   static
    {
        System.loadLibrary("JNITest");//名字注意，需要跟你的build.gradle ndk节点下面的名字一样
    }
5.调用 （new native方法类的对象,调用方法）

6.生成SO文件后在其他项目中如何调用,参考ProjectAddSODemo工程