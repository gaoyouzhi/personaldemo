package com.haochang.redis;

import com.haochang.dao.UserDAO;
import com.haochang.model.FrUser;
import com.haochang.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述：缓存穿透解决方案
 * 缓存穿透  缓存中永远不存在 的key导致每次访问数据库  即缓存穿透
 * @author: youzhi.gao
 * @date: 2020-06-29 17:56
 */
public class CachePenetrate {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserDAO userDAO;

    private Map<String, Object> localCache = Collections.synchronizedMap(new HashMap<>());

    //使用空对象
    public FrUser getUser(String userName){
        Object o = localCache.get(userName);
        if(null != o){
            if(o instanceof NullValueObjectDO){
                return null;
            }

            return (FrUser) o;
        } else{
            FrUser user = userDAO.getUserByNickName(userName);
            if(null != user){
                localCache.put(userName, user);
            } else {
                localCache.put(userName, new NullValueObjectDO());
            }

            return user;
        }
    }


    //使用布隆过滤器
    public FrUser getUserByFilter(String nickName){
        BloomFilter bloomFilter = null;

        return new FrUser();
    }
}
