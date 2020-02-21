package com.ikang.demo;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/20
 */
public class TestStackOutOfMemory {
    public static void main(String[] args) {
        for (int i = 0;i < Integer.MAX_VALUE;i++) {
            String a = new String("abc");
            System.out.println(a + "============" + i);
        }
    }

}
