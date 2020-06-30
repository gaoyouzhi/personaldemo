package com.haochang.dao;

import com.haochang.model.FrUser;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * @description: 描述：用户DAO
 * @author: youzhi.gao
 * @date: 2020-06-29 17:20
 */
@Repository
public class UserDAOImpl implements UserDAO {

   public FrUser getUserById(Long id){
       return new FrUser();
   }

   public FrUser getUserByNickName(String nickName){
        return new FrUser();
    }
}
