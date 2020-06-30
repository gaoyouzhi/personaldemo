package com.haochang.dao;

import com.haochang.model.FrUser;

/**
 * @description: 描述：用户DAO接口
 * @author: youzhi.gao
 * @date: 2020-06-29 17:30
 */
public interface UserDAO {

    FrUser getUserById(Long id);

    FrUser getUserByNickName(String nickName);
}
