package com.ikang.service.impl;

import com.ikang.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * Created by gaoyouzhi on 2020/3/6.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void query(Long id) {
        System.out.println("this is the order, it's id is " + id);
    }
}
