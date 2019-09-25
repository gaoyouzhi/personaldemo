package com.ikang.test;

import com.ikang.App;
import com.ikang.domain.Message;
import com.ikang.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class TestRedis {

    @Autowired
    private RedisUtil redisUtil;



    public void testString(){
        String key = "str_key";
        int value = 10;
        boolean flag = redisUtil.set(key, value, 0);

        System.out.println("----------------------设置key:" + key + "---------------结果：" + flag);
        System.out.println("value:" + redisUtil.get(key).toString());


    }


    public void testMap(){
        Map<String, Object> messages = new HashMap<>();
        for (int i = 0; i <10 ; i++) {
            messages.put(i + "", new Message("这是第" + (i+1) + "条数据", 1));
        }

        String message_key = "IKANG_Message";
//        redisUtil.del(message_key);
        if(!redisUtil.hasKey(message_key)){
            redisUtil.hmset(message_key, messages);
        }

        Map<Object, Object> map = redisUtil.hmget(message_key);
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            String k = (String) it.next();
            System.out.println(map.get(k).toString());
        }
    }


    public void testList(){
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            messages.add(new Message("这是list中的第" + (i+1) + "条数据", i % 2));
        }
        String listKey = "IKANG_LIST";
//        redisUtil.del(listKey);
        if(!redisUtil.hasKey(listKey)){
            redisUtil.lSet(listKey, messages);
        }

        List list = redisUtil.lGet(listKey, 0, -1);
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }


    public void testSet(){
        Set<Message> messages = new HashSet<>();
        for (int i = 0; i <10 ; i++) {
            messages.add(new Message("这是set中的第" + (i+1) + "条数据", i % 2));
        }

        String setkey = "IKANG_SET";

        redisUtil.del(setkey);
        if(!redisUtil.hasKey(setkey)){
            redisUtil.sSet(setkey, messages);
        }

        Set set = redisUtil.sGet(setkey);
        System.out.println(Arrays.toString(set.toArray()));

//        Iterator it = set.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next().toString());
//        }
    }

    @Test
    public void testZset(){
        Set<Message> messages = new HashSet<>();
        for (int i = 0; i <10 ; i++) {
            messages.add(new Message("这是set中的第" + (i+1) + "条数据", i % 2));
        }

        String zsetkey = "IKANG_ZSET";
        System.out.println(zsetkey);
        redisUtil.del(zsetkey);
        if(!redisUtil.hasKey(zsetkey)){
            redisUtil.zZset(zsetkey, messages);
        }

        Set set = redisUtil.zZget(zsetkey, 0, -1);
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
