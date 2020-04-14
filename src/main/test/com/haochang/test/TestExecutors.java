package com.haochang.test;

import com.haochang.App;
import com.haochang.service.AsyncService;
import com.haochang.service.impl.AsyncServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class TestExecutors {
    private static final Log log = LogFactory.getLog(TestExecutors.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private OrderService orderService;


//    @Test
//    public void executeTest(){
//        log.info("start submit");
//
//        //调用service层的任务
//        asyncService.executeAsync();
//
//        log.info("end submit");
//    }

    @Test
    public void executeTest(){
        log.info("start submit");

        orderService.query(111);

        log.info("end submit");
    }
}
