package com.haochang.threadlocal;

import com.haochang.model.FrUser;

/**
 * @description: 描述：threadlocal应用场景2
 * @author: youzhi.gao
 * @date: 2020-07-15 15:09
 */
public class ThreadLocalDemo05 {
    public static void main(String[] args) {
        new Service1().service1();
    }
}

class Service1{
    public void service1(){
        FrUser frUser = new FrUser();
        frUser.setLoginName("hello world");
        UserContextHolder.threadLocal.set(frUser);
        new Service2().service2();
    }
}

class Service2{

    public void service2() {
        FrUser frUser = UserContextHolder.threadLocal.get();
        System.out.println("service2获取到的用户" + frUser.getLoginName());
        new Service3().service3();
    }
}

class Service3{


    public void service3() {
        FrUser frUser = UserContextHolder.threadLocal.get();
        System.out.println("service3获取到的用户名称为" + frUser.getLoginName());
        UserContextHolder.threadLocal.remove();
    }

}

class UserContextHolder{
    public static ThreadLocal<FrUser> threadLocal = new ThreadLocal<>();
}