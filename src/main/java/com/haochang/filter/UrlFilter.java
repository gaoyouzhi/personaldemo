package com.haochang.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description: 描述：针对每个请求的过滤器，过滤无效请求
 * 如果加webFilter注解，即可自动注入，如果多个走配置，按顺序注册
 * @author: youzhi.gao@ikang.com
 * @date: 2020-01-21 14:48
 */
//@WebFilter
public class UrlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤完毕@");
    }
}
