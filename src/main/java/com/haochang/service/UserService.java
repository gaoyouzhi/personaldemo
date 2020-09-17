package com.haochang.service;

import com.haochang.model.FrUser;

/**
 * @ClassName: UserService
 * @Description TODO
 * @Author: youzhi.gao
 * @Date: 2020-09-16 17:50
 * @Version 1.0.0
 */
public interface UserService {

    void insert(FrUser frUser);

    void delete(FrUser frUser);
}
