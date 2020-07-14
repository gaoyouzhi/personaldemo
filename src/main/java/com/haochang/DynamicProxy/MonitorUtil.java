package com.haochang.DynamicProxy;

/**
 * @description: 描述：监控时间工具类
 * @author: youzhi.gao
 * @date: 2020-04-16 14:55
 */
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
