package com.haochang.test;

import com.haochang.model.FrUser;
import com.haochang.model.FrUserRole;
import com.haochang.service.RoleService;
import com.haochang.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

/**
 * @description: 描述：测试事务
 * @author: youzhi.gao
 * @date: 2020-09-16 18:00
 */
@SpringBootTest
public class TestTranscation {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    public void testNewTx(){

    }

}
