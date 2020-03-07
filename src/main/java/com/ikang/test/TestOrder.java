package com.ikang.test;

import com.ikang.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaoyouzhi on 2020/3/6.
 */
@Controller()
@RequestMapping("/order")
public class TestOrder {

    private static final Log log = LogFactory.getLog(TestOrder.class);

    @Autowired
    private OrderService orderService;


    @RequestMapping("/query")
    public String executeTest(){
        log.info("start submit");

        orderService.query(111L);

        log.info("end submit");

        return "success";
    }

}
