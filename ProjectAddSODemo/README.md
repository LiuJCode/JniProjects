#一个项目中调用SO文件
1.在main目录下新建jniLibs目录，将so文件复制到该目录
2.创建一个JniJava类，注意这个类的包名必须和C代码这个jni包名一样。在该类中实现native方法，以及加载这个so库。
3.接下来就可以使用了。

#如何生成jar包，将java和c以jar包形式使用。
1.如果工程属于主工程，需要修改 build.gradle
   (1).修改apply plugin: 'com.android.application' -> apply plugin: 'com.android.library'。
        这一步如果是导出其他library是不需要修改的。 修改后一定要将项目clear。
   (2).在build.gradle中 android{}外新增(如果是生成library的jar包，就需要把以下代码放在library中):
        task makeJar(type: Copy) {
            //删除存在的
            delete 'build/libs/myjni.jar'
            //设置拷贝的文件
            from('build/intermediates/bundles/debug/')
            //打进jar包后的文件目录
            into('build/libs/')
            //将classes.jar放入build/libs/目录下
            //include ,exclude参数来设置过滤
            //（我们只关心classes.jar这个文件）
            include('classes.jar')
            //重命名
            rename ('classes.jar', 'myjni.jar')
        }
        makeJar.dependsOn(build)
   (3).在底部点击terminal 输入 gradlew makeJar
   这样出现 build SUCCESSFUL 就表示jar包已经生成.生成的jar包地址在build->libs


如何使用生成的jar和so文件  (jar包中是不包含so文件的 所以so文件需要手动复制到工程中.)