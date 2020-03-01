package com.ikang.config;

import com.ikang.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/29
 */
@Configuration
public class Rabbitmq {

    /**
     * rabbitMQ服务器的地址
     */
    @Value("${spring.rabbitmq.addresses}")
    private String addresses;
    /**
     * rabbitMQ用户名
     */
    @Value("${spring.rabbitmq.username}")
    private String username;
    /**
     * rabbitMQ密码
     */
    @Value("${spring.rabbitmq.password}")
    private String password;
    /**
     * rabbitMQ虚拟机 这里默认 /
     */
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    /**
     * 注册rabbitMQ的Connection
     *
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setAddresses(this.addresses);
        cachingConnectionFactory.setUsername(this.username);
        cachingConnectionFactory.setPassword(this.password);
        cachingConnectionFactory.setVirtualHost(this.virtualHost);
        return cachingConnectionFactory;
    }

    /**
     * 注册rabbitAdmin 方便管理
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue dirteQueue(){
        return new Queue(RabbitMqConstant.IKANG_ORDER_QUEUE);
    }

    @Bean
    public DirectExchange orderExchange(){
        return new DirectExchange(RabbitMqConstant.IKANG_ORDER_EXCHANGE);
    }

    @Bean
    public Binding orderBinding(){
        return BindingBuilder.bind(dirteQueue()).to(orderExchange()).with(RabbitMqConstant.IKANG_ORDER_ROUTING_KEY);
    }


    @Bean
    public Queue topicQueue(){
        return new Queue(RabbitMqConstant.IKANG_PAY_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(RabbitMqConstant.IKANG_PAY_EXCHANGE);
    }

    @Bean
    public Binding payBinding(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(RabbitMqConstant.IKANG_PAY_ROUTING_KEY);
    }

}
