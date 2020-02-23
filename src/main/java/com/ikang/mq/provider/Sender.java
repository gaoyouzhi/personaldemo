//package com.ikang.mq.provider;
//
//import com.ikang.model.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class Sender {
//
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @RequestMapping("/sendMailBox")
//    public Message sendMailBox(Message message){
////        Message message1 = new Message("hello", 1);
////        System.out.println(message1.toString());
//        jmsTemplate.convertAndSend("mailbox", message);
//        return message;
//    }
//
//    @RequestMapping("/sendMessage")
//    public Message sendMessage(Message message){
////        Message message1 = new Message("hello", 1);
////        System.out.println(message1.toString());
//        jmsTemplate.convertAndSend("messageQueue", message);
//        return message;
//    }
//
//
//}
