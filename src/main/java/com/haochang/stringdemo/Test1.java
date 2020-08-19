package com.haochang.stringdemo;

/**
 * @description: 描述：测试字符串创建了多少对象
 * @author: youzhi.gao
 * @date: 2020-08-12 13:44
 */
public class Test1 {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
    }

    private static void test8() {

//        String c = "33";
        String d = "44" + new String("55");

        System.out.println(d);
    }

    /**
     * 方法功能描述：
     * @MethodName: test7
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-17 9:23
     */
    private static void test7() {
        String a = "11";
        String b = "11" + new String("22");
        System.out.println(b);
    }


    /**
     * 方法功能描述：
     * @MethodName: test6
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-12 17:17
     */
    private static void test6() {
        String s = "6";
        String s1 = "6";
        String ss = s + s1;

//        s2.intern();

        String s3 = "66";

        System.out.println(ss == s3);
    }

    /**
     * 方法功能描述：
     * @MethodName: test5
     * @param 
     * @Return: 
     * @Author: yz.gao
     * @Date: 2020-08-12 17:12
     */
    private static void test5() {
        final String s = "5";
        final String s1 = "5";
        String s2 = s + s1;

//        s2.intern();

        String s3 = "55";

        System.out.println(s2 == s3);


    }

    /**
     * 方法功能描述：
     * @MethodName: test4 
     * @param
     * @Return: 
     * @Author: yz.gao
     * @Date: 2020-08-12 17:00
     */
    private static void test4() {
        String s = "33";
        String ss = "3" + "3";

        System.out.println(s == ss);
    }

    /**
     * 方法功能描述：测试字符串内存地址
     * @MethodName: test3
     * @param
     * @Return:
     * @Author: yz.gao
     * @Date: 2020-08-12 16:56
     */
    private static void test3() {
        String s2 = new String("22");
        String s = "22";

        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s == s2);
        System.out.println(s.equals(s2));
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
