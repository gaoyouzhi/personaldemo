package com.haochang.demo;

/**
 * Created by gaoyouzhi on 2020/2/21.
 */
public class TestString {
    public static void main(String[] args) {
        String a = "java is a language. c is a language.";
        System.out.println(a.replace("S", "xxx"));
        System.out.println(a.replaceAll("S", "yyy"));
    }
}
