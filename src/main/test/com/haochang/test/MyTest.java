package com.haochang.test;

import com.haochang.classloader.MyClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @description: 描述：我的测试
 * @author: youzhi.gao
 * @date: 2020-01-20 17:15
 */
public class MyTest {
    public static void main(String[] args) throws Exception {
        //1.读取字节码文件转换成数组
        File file = new File(".");
        InputStream  input = new FileInputStream(file.getCanonicalPath()+"\\target\\classes\\com\\haochang\\model\\FrRole.class");
        //2.
        byte[] result = new byte[10240];
        int count = input.read(result);
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.defineMyClass(result, 0, count);
        System.out.println(clazz.getCanonicalName());

        Object o = clazz.newInstance();

        clazz.getMethod("setName", String.class).invoke(o, "123");
        System.out.printf(clazz.getMethod("getName", null).invoke(o, null) + "");
    }
}
