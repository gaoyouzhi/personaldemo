package com.haochang.controller;

import com.haochang.util.ChannelUtil;
import com.haochang.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private ChannelUtil channelUtil;


    @RequestMapping("/getRedisList")
    public void getRedisList(){
        String path = channelUtil.getChannelRelWebservicePath("XMD");
        System.out.println(path);
        String curl = channelUtil.getChannelRelWebserviceUrl("XMD");
        System.out.println(curl);
    }


}
