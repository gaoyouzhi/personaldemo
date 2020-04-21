package com.haochang.service;

/**
 * @ClassName: AccessService
 * @Description 限流服务器
 * @Author: youzhi.gao
 * @Date: 2020-04-21 15:02
 * @Version 1.0.0
 */
public interface AccessService {
    boolean tryAcquire();
}
