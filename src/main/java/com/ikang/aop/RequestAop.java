package com.ikang.aop;

import com.mchange.v1.util.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 描述：过滤所有请求进行验证
 * @author: youzhi.gao@ikang.com
 * @date: 2020-01-20 16:29
 */
public class RequestAop {
    private static final Logger log = LoggerFactory.getLogger(RequestAop.class);


    /**
     * 请求参数拦截校验
     */
    @Aspect
    public class AopParamVerify {

        @Around(value = "execution(* com.ikang.controller..*.*(..))")
        public Object invoke(ProceedingJoinPoint joinPoint) {


            //1.这里获取到所有的参数值的数组
            Object[] args = joinPoint.getArgs();
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            //2.最关键的一步:通过这获取到方法的所有参数名称的字符串数组
            String[] parameterNames = methodSignature.getParameterNames();
            try {

                return joinPoint.proceed();
            } catch (Throwable throwable) {
                log.error("时间戳校验异常");
                throwable.printStackTrace();
            }
            return null;
        }
    }
}
