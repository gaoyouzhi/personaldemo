package com.haochang.service.impl;

import com.haochang.mapper.FrUserMapper;
import com.haochang.model.FrUser;
import com.haochang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 描述：用户service
 * @author: youzhi.gao
 * @date: 2020-09-16 17:51
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FrUserMapper frUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insert(FrUser frUser) {
        frUserMapper.insert(frUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void delete(FrUser frUser) {
        frUserMapper.selectByPrimaryKey(frUser.getId());
    }
}
