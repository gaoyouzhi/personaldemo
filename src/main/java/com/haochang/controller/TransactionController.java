package com.haochang.controller;

import com.haochang.model.FrUser;
import com.haochang.model.FrUserRole;
import com.haochang.service.RoleService;
import com.haochang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 描述：事务controller
 * @author: youzhi.gao
 * @date: 2020-09-16 18:04
 */
@RequestMapping("/tx")
@Transactional
@Controller
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping("/test1")
    @ResponseBody
    public void test1(){
        FrUser frUser = new FrUser();
        frUser.setLoginName("1111");
        frUser.setUserName("123456");
        frUser.setId(1111);
        userService.insert(frUser);//如果开启了新事务则不影响外部事务，会影响

        try {
            FrUserRole frUserRole = new FrUserRole();
            frUserRole.setId(111);
            frUserRole.setRoleId(222);
            roleService.insert(frUserRole);//如果没开启事务，就算try catch  框架也会手动抛出异常  不会提交
        }catch (Exception e){

        }

    }


    @RequestMapping("/test2")
    public void test2(){

        try {
            FrUserRole frUserRole = new FrUserRole();
            frUserRole.setId(111);
            frUserRole.setRoleId(222);
            roleService.insert(frUserRole);
        }catch (Exception e){

        }

        FrUser frUser = new FrUser();
        frUser.setLoginName("2222");
        frUser.setUserName("123456");
        frUser.setId(2222);
        userService.insert(frUser);
    }

    @RequestMapping("/test3")
    public void test3(){
        try{
            FrUserRole frUserRole = new FrUserRole();
            frUserRole.setId(111);
            frUserRole.setRoleId(222);
            roleService.insert(frUserRole); // 开启了新事务  执行结束即结束  手动捕获不影响外部事务

        } catch (Exception e){
            e.printStackTrace();
        }


        FrUser frUser = new FrUser();
        frUser.setLoginName("3333");
        frUser.setUserName("123456");
        frUser.setId(3333);
        userService.insert(frUser);
    }

    @RequestMapping("/test5")
    public void test5(){
        FrUserRole frUserRole = new FrUserRole();
        frUserRole.setId(111);
        frUserRole.setRoleId(222);
        roleService.insert(frUserRole);// 开启了新事务  执行结束即结束  未手动捕获影响外部事务


        FrUser frUser = new FrUser();
        frUser.setLoginName("4444");
        frUser.setUserName("123456");
        frUser.setId(5555);
        userService.insert(frUser);
    }
}
