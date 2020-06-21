package com.ikang.controller;

import com.ikang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gaoyouzhi
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private OrderService orderService;

    @RequestMapping("/testBoot")
    public String testBoot(){
        orderService.query(111L);
        return "success";
    }

}
