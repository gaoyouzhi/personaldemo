package com.haochang.stringdemo;

/**
 * @description: 描述：测试字符串创建了多少对象
 * @author: youzhi.gao
 * @date: 2020-08-12 13:44
 */
public class Test1 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 方法功能描述：测试new 字符串
     * @MethodName: test2
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-12 13:59
     */
    private static void test2() {
        String a = new String("1");
        String b = new String("1");

        String c = "1";


        System.out.println(a == c);
        System.out.println(b == c);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
    }

    /**
     * 方法功能描述：直接拼接
     * @MethodName: test1
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-12 13:44
     */
    private static void test1() {
        String s1 = "1";
        String s2 = "1";

        String ss = "1" + "1";
        String s = "11";

        System.out.println(s == ss);

    }


}
