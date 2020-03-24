package com.ikang.test;

/**
 * @description: 描述：字符串常量池测试
 * @author: youzhi.gao
 * @date: 2020-01-21 11:12
 */
public class StringTest {
    public static void main(String[] args) {
//        testConstant();
        testNewStr();
//        testIntern();
//        testIntern1();
    }

    private static void testIntern1() {
        //第二种情况
        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);
    }

    private static void testIntern() {
        String s1 = new String("1");
        String s3 = s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);

    }

    private static void testNewStr() {
        String s1 = new String("a") + new String("b") + new String ("c");
        String s2 = new String("abc");
        System.out.println(s1==s2);
    }

    private static void testConstant() {
        String s1 = "a" + "bc";
//        s1+="bc";
//        s1 = s1 + "bc";
        String s2 = "abc";
        System.out.println(s1==s2);
    }
}
