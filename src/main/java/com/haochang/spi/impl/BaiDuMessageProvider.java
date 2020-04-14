package com.haochang.spi.impl;

import com.haochang.spi.MessageProvider;

/**
 * @description: 描述：百度短信服务实现类
 * @author: youzhi.gao
 * @date: 2020-04-14 09:57
 */
public class BaiDuMessageProvider implements MessageProvider {
    @Override
    public void send() {
        System.out.println("hello, i am baidu message provider");
    }

}
