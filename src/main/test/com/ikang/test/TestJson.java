package com.ikang.test;

import com.alibaba.fastjson.JSON;
import com.ikang.App;
import com.ikang.model.Message;
import com.ikang.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class TestJson {

    @Autowired
    private RedisUtil redisUtil;


    public void testJsonStr(){
        Message message = new Message();
        message.setStatus(1);
        message.setMessage("hello world");
//        Map<String, Object> map = new HashMap();
//        map.put("haha", message);
        String key = "json_key";
        String value = JSON.toJSON(message).toString();
        System.out.println(value);
        redisUtil.set(key, value);
        if(redisUtil.hasKey(key)){
            String str = (String) redisUtil.get(key);
            Message msg = JSON.parseObject(str, Message.class);
            System.out.println(msg);
        }
    }

    @Test
    public void testJsonMap(){
        Message message = new Message();
        message.setStatus(2);
        message.setMessage("heihei");
        Map<String, Object> map = new HashMap();
        String mapkey = "11111";
        map.put(mapkey, message);
        String key = "json_map_key111";
//        String value = JSON.toJSON(message).toString();
//        System.out.println(value);
        boolean flag = redisUtil.hmset(key, map);
        if(flag){
            if(redisUtil.hasKey(key)){
                Map<Object, Object> mget = redisUtil.hmget(key);
                if(mget.containsKey(mapkey)){
                    System.out.println(mget.get(mapkey).toString());
                }
            }
        }

    }
}
