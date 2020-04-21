package com.haochang.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.haochang.service.AccessService;
import org.springframework.stereotype.Component;

/**
 * @description: 描述：限流服务实现类
 * @author: youzhi.gao
 * @date: 2020-04-21 15:03
 */
@Component
public class AccessServiceImpl implements AccessService {

    //每秒钟发放一个令牌
    private static final RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    public boolean tryAcquire() {
        if(rateLimiter.tryAcquire()){
            return true;
        }
        return false;
    }
}
