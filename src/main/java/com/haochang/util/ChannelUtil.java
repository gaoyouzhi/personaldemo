package com.haochang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Service
public class ChannelUtil {

    @Autowired
    private RedisUtil redisUtil;

    private final static Logger logger = LoggerFactory.getLogger(ChannelUtil.class);


    /**
     * 通过判断获得渠道对应仓库ID
     *
     * @param channelCode
     * @return
     */
    public Long channelLogic(String channelCode) {
        Long warehouseId = getChannelWarehouseId(channelCode);
        return warehouseId;
    }

    /**
     * 渠道基本信息 CH
     *
     * @param channelCode
     * @return
     */
    public Long getChannelWarehouseId(String channelCode) {
        Map<Object, Object> map = redisUtil.hGetAll("CH-" + channelCode);
        if (Objects.nonNull(map) && Objects.nonNull(map.get("warehouseId"))) {
            return Long.parseLong(map.get("warehouseId").toString());
        } else {
            return null;
        }
    }


    /**
     * 渠道基本信息 CH
     * 判断是否是字符串外部订单渠道
     *
     * @param channelCode
     * @return
     */
    public boolean getOfOuterIdStr(String channelCode) {
        if (Objects.nonNull(redisUtil.hGetAll("CH-" + channelCode).get("type3")) && redisUtil.hGetAll("CH-" + channelCode).get("type3").equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 渠道基本信息 CSE
     * 根据 发货 渠道 获取远程服务 path
     *
     * @param channelCode
     * @return
     */
    public String getChannelRelWebservicePath(String channelCode) {
        Map<Object, Object> map = redisUtil.hGetAll("CSE-" + channelCode);
        if (Objects.nonNull(map) && Objects.nonNull(map.get("path"))) {
            return map.get("path").toString();
        } else {
            return null;
        }
    }

    /**
     * 渠道基本信息 CSE
     * 根据 发货 渠道 获取远程服务 url
     *
     * @param channelCode
     * @return
     */
    public String getChannelRelWebserviceUrl(String channelCode) {
        Map<Object, Object> map = redisUtil.hGetAll("CSE-" + channelCode);
        if (Objects.nonNull(map) && Objects.nonNull(map.get("url"))) {
            return map.get("url").toString();
        } else {
            return null;
        }
    }

}
