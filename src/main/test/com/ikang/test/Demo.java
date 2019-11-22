package com.ikang.test;

import com.alibaba.fastjson.JSON;
import com.ikang.domain.Message;
import com.ikang.model.RmsSmsTemplate;
import com.ikang.vo.RmsSmsTemplateVo;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        System.out.println("happy " + String.valueOf(1<<10));
//        RmsSmsTemplateVo rmsSmsTemplateVo = new RmsSmsTemplateVo();
//        rmsSmsTemplateVo.setcChannelId(1L);
//        rmsSmsTemplateVo.setcGoodsTpye(1L);
//        rmsSmsTemplateVo.setcId(1L);
//        RmsSmsTemplate rmsSmsTemplate = new RmsSmsTemplate();
//        BeanUtils.copyProperties(rmsSmsTemplateVo, rmsSmsTemplate);
//        System.out.println(rmsSmsTemplateVo.toString());

//        testStr();
//        String[] hospids = new String[]{"525","526"};
//        Set<String> pqSet = new HashSet<String>();
//        String [] pqAllKey = pqSet.toArray(new String[!"000".equals("000")? hospids.length<<1 : hospids.length]);
//        System.out.println(Arrays.toString(pqAllKey));

    testJson();
    }


    private static void testStr() {
//        String a = "1";
//        Map<String, Object> map = new HashMap<>();
//        map.put("a", a);
//        Integer s = Integer.parseInt((String) map.get("a"));
//        System.out.println(s);
    }

    private static void testJson(){

        Message message = new Message();
        message.setMessage("111");

        Message message2 = new Message();
        message2.setMessage("222");
        List list = new ArrayList();
        list.add(message);
        list.add(message2);


        System.out.println(JSON.toJSONString(list));

    }

}
