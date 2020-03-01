package com.ikang.mq.provider;

import com.alibaba.fastjson.JSON;
import com.ikang.config.Rabbitmq;
import com.ikang.constant.RabbitMqConstant;
import com.ikang.model.FrUser;
import com.ikang.model.FrUserDept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/23
 */
@Service
public class RabbitmqProvider {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqProvider.class);

    /**
     * 自动注入RabbitTemplate模板类
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRabbitMq(){
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        FrUserDept frUserDept = new FrUserDept();
        frUserDept.setUserId(10001);
        frUserDept.setId(10086);
        frUserDept.setDeptId(1234);
        String json = JSON.toJSONString(frUserDept);
        rabbitTemplate.convertAndSend(RabbitMqConstant.IKANG_PAY_EXCHANGE, RabbitMqConstant.IKANG_PAY_ROUTING_KEY, json);
        logger.info("发送消息到队列" + json);
    }


    /**
     * 回调函数: confirm确认
     */
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData);
            System.err.println("ack: " + ack);
            if(!ack){
                System.err.println("异常处理....");
            }
        }
    };

    /**
     * 回调函数: return返回
     */
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText,
                                    String exchange, String routingKey) {
            System.err.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };

    /**
     * 发送消息方法调用: 构建Message消息
     */
    public void send() throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一
        CorrelationData correlationData = new CorrelationData("1234567890");
        rabbitTemplate.convertAndSend("exchange-1", "springboot.abc", "123456", correlationData);
    }
}
