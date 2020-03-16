package com.haochang.classloader;

/**
 * @description: 描述：自定义类加载器
 * @author: youzhi.gao@ikang.com
 * @date: 2020-01-20 17:50
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass( byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}
