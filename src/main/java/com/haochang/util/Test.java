package com.haochang.util;

import com.haochang.model.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述：1
 * @author: youzhi.gao
 * @date: 2020-07-09 15:55
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        getData(map);
        System.out.println(map.get("aaa"));
        String a = "aaaa";
        Message message = new Message();
        message.setId(222);
        getInteger(a);
        System.out.println(a);
        StringBuffer sb = new StringBuffer();
        getSb(sb);
        System.out.println(sb.toString());
        getMessage(message);
        System.out.println(message.getId());
    }
    private static void getMessage(Message message) {
        message.setId(111);
    }
    private static void getSb(StringBuffer sb) {
        sb.append("aaa");
        sb.append("bbb");
    }
    private static void getInteger(String a) {
        a.toUpperCase();
    }
    private static void getData(Map<String, Object> map) {
        map.put("aaa", "aaa");
    }
}
