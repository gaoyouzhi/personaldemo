package com.haochang.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 描述：针对每个请求的过滤器，过滤无效请求
 * 如果加webFilter注解，即可自动注入，如果多个走配置，按顺序注册
 * @author: youzhi.gao
 * @date: 2020-01-21 14:48
 */
public class UrlFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UrlFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
