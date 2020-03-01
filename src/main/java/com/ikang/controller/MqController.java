package com.ikang.controller;

import com.ikang.mq.provider.RabbitmqProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaoyouzhi on 2020/2/29.
 */
@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private RabbitmqProvider rabbitmqProvider;

    @RequestMapping("/send")
    public String send(){
        rabbitmqProvider.sendRabbitMq();
        return "success";
    }

}
