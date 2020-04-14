package com.haochang.spi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description: 描述：test
 * @author: youzhi.gao
 * @date: 2020-04-14 09:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpiTest {

    @Test
    public void testSpi() throws Exception{
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(MessageProvider::send);
    }
}
