package com.ikang.mq.consumer;

import com.ikang.domain.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "messageQueue", concurrency = "2")
    public void receiveMessage(Message message){
        System.out.println("Receive message from messageQueue --" + message + "--------");

    }


    @JmsListener(destination = "mailbox", concurrency = "2")
    public void receiveMailMessage(Message message){
        System.out.println("Receive message from mailbox --" + message + "--------");
    }
}
