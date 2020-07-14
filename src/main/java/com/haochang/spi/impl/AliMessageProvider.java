package com.haochang.spi.impl;

import com.haochang.spi.MessageProvider;

/**
 * @description: 描述：短信服务实现类
 * @author: youzhi.gao
 * @date: 2020-04-14 09:56
 */
public class AliMessageProvider implements MessageProvider {
    @Override
    public void send() {
        System.out.println("hello, i am ali message provider");
    }

}
