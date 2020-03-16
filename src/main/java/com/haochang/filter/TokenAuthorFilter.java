package com.haochang.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 描述：
 * @author: youzhi.gao@ikang.com
 * @date: 2020-01-21 15:06
 */
public class TokenAuthorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
