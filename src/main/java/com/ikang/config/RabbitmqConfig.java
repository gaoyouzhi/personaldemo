package com.ikang.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/22
 */
@Configuration
public class RabbitmqConfig {

    //------->商品订单
    /**
     *  商品订单充值成功队列
     */
    public static final String GOOD_ORDER_PAY_SUCCESS_QUEUE_NAME = "goodOrderPaySuccessQueue";

    /**
     *  商品订单打印队列
     */
    public static final String GOOD_ORDER_PAY_TIMEOUT_QUEUE_NAME = "goodOrderPayTimeoutQueue";
    //商品订单充值失败队列

    /**
     *  路由键
     */
    public static final String GOOD_ORDER_PAY_SUCCESS_ROUTE_KEY = "goodOrderSuccess";
    public static final String GOOD_ORDER_PAY_TIMEOUT_ROUTE_KEY = "goodOrderTimeout";
    // public static final String GOOD_ORDER_PAY_SUCCESS_PRINT_ROUTE_KEY="goodOrderSuccess";

    /**
     *  交换器
     */
    public static final String EXCHANGE_NAME = "orderPayExchange";

    /**
     *  支付成功队列
     */
    @Bean
    public Queue goodOrderPaySuccessQueue(){
        return new Queue(GOOD_ORDER_PAY_SUCCESS_QUEUE_NAME,true);
    }

    /**
     * 订单支付超时队列
     * @return
     */
    @Bean
    public Queue goodOrderPayTimeoutQueue(){
        return new Queue(GOOD_ORDER_PAY_TIMEOUT_QUEUE_NAME,true);
    }


    /**
     * 声明交换器
     * @return
     */
    @Bean
    public TopicExchange orderExchange(){
        return new TopicExchange (EXCHANGE_NAME);
    }

    /**
     * @return
     */
    @Bean
    public Binding bindingOrderSuccess(){
        return BindingBuilder.bind(goodOrderPaySuccessQueue()).to(orderExchange()).with(GOOD_ORDER_PAY_SUCCESS_ROUTE_KEY);
    }

    @Bean
    public Binding bindingOrderFail(){
        return BindingBuilder.bind(goodOrderPayTimeoutQueue()).to(orderExchange()).with(GOOD_ORDER_PAY_TIMEOUT_ROUTE_KEY);
    }
    //<-------商品订单

    //------->充值订单
    /**
     *  充值订单充值成功队列
     */
    public static final String RECHARGE_ORDER_PAY_SUCCESS_QUEUE_NAME="rechargeOrderPaySuccessQueue";

    /**
     *  充值订单充值失败队列
     */
    public static final String RECHARGE_ORDER_PAY_TIMEOUT_QUEUE_NAME = "rechargeOrderPayTimeoutQueue";

    public static final String RECHARGE_ORDER_PAY_SUCCESS_ROUTE_KEY = "rechargeOrderSuccess";

    public static final String RECHARGE_ORDER_PAY_TIMEOUT_ROUTE_KEY = "rechargeOrderTimeout";

    @Bean
    public Queue rechargeOrderPaySuccessQueue(){
        return new Queue(RECHARGE_ORDER_PAY_SUCCESS_QUEUE_NAME,true);
    }

    @Bean
    public Queue rechargeOrderTimeoutQueue(){
        return new Queue(RECHARGE_ORDER_PAY_TIMEOUT_QUEUE_NAME,true);
    }

    @Bean
    public Binding bindingRechargeSuccess(){
        return BindingBuilder.bind(rechargeOrderPaySuccessQueue()).to(orderExchange()).with(RECHARGE_ORDER_PAY_SUCCESS_ROUTE_KEY);
    }
    @Bean
    public Binding bindingRechargeFailed(){
        return BindingBuilder.bind(rechargeOrderTimeoutQueue()).to(orderExchange()).with(RECHARGE_ORDER_PAY_TIMEOUT_ROUTE_KEY);
    }
    //<-------充值订单

}

