package com.ikang.mq.consumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

/**
 * Created by gaoyouzhi on 2020/2/29.
 */
@RabbitListener(queues = {"ikang_pay_queue"})
public class RabbitmqConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqConsumer.class);
    /**
     * 接收字符串消息,确认消息收到之后,把消息从队列中移除,如未移除,项目重启之后还会继续推送消息
     */
    @RabbitHandler
    public void process(String str, Channel channel, Message message) {
        logger.info("-->ikang_pay_queue  Println: " + str + ", 收到时间: " + System.currentTimeMillis());

        try {

            // 告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.info("-->ikang_pay_queue  SUCCESS!");
        } catch (IOException e) {
            e.printStackTrace();
            // ack返回false，并重新回到队列
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // 拒绝消息
            //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            logger.info("-->HelloAMsgReceiver AAAA FAIL!");

        }
    }
}
