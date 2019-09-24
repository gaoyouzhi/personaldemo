package com.ikang.test;

import com.ikang.App;
import com.ikang.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class TestRedis {

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void test(){
        String key = "str_key";
        int value = 10;
        boolean flag = redisUtil.set(key, value, 0);

        System.out.println("----------------------设置key:" + key + "---------------结果：" + flag);
        System.out.println("value:" + redisUtil.get(key).toString());



    }
}
