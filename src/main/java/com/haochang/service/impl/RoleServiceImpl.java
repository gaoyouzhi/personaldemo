package com.haochang.service.impl;

import com.haochang.mapper.FrRoleMapper;
import com.haochang.mapper.FrUserRoleMapper;
import com.haochang.model.FrUserRole;
import com.haochang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 描述：角色 service
 * @author: youzhi.gao
 * @date: 2020-09-16 17:52
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{


    @Autowired
    private FrUserRoleMapper frUserRoleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insert(FrUserRole frUserRole) {
        frUserRoleMapper.insert(frUserRole);
    }

    @Override
    public void delete(FrUserRole frUserRole) {
        frUserRoleMapper.deleteByPrimaryKey(frUserRole.getId());
    }
}
