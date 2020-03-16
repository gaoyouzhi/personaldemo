package com.haochang.config;

import com.ikang.filter.TokenAuthorFilter;
import com.ikang.filter.UrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @description: 描述：为了管理多个过滤器，统一配置
 * order 值越小 过滤器越先执行
 * @author: youzhi.gao@ikang.com
 * @date: 2020-01-21 14:53
 */
@Configuration
public class FilterConfig {

    @Bean
    public Filter myUrlFilter(){
        return new UrlFilter();
    }

    @Bean
    public Filter tokenAuthorFilter(){
        return new TokenAuthorFilter();
    }

    @Bean
    public FilterRegistrationBean urlFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myUrlFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(5);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean tokenAuthorFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(tokenAuthorFilter());
        filterRegistrationBean.addUrlPatterns("/app/*");
        filterRegistrationBean.setOrder(6);

        return filterRegistrationBean;
    }
}
