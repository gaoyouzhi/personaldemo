package com.haochang.aop;

import com.alibaba.fastjson.JSON;
import com.haochang.model.Message;
import com.haochang.util.AESUtil;
import com.ikang.model.Message;
import com.ikang.util.AESUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @description: 描述：aop进行统一加密验证
 * @author: youzhi.gao
 * @date: 2020-02-14 10:50
 */
//@Aspect
//@Component
public class EncryptionAuth {


    private static final Logger logger = LoggerFactory.getLogger(EncryptionAuth.class);


    @Pointcut("execution( * com.ikang.exam.controller.*.*(..))")
    public void EncryptionAuthCut() {
    }

    @Around("EncryptionAuthCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("请求类型 : " + request.getMethod());
        logger.info("实现方法: " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());

        logger.info("参数 : " + Arrays.toString(pjp.getArgs()));
        Message message = JSON.parseObject(JSON.toJSONString(pjp.getArgs()[0]), Message.class);

        String signNew = DigestUtils.md5Hex(message.getMessage());

        if(!signNew.equals("abc")){
            return "fail";
        }

        String data = AESUtil.decrypt("1bs");
        Object[] o = new Object[1];

        o[0] = data;
        return pjp.proceed(o);
    }


}
