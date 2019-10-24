package com.ikang.test;

import com.ikang.model.RmsSmsTemplate;
import com.ikang.vo.RmsSmsTemplateVo;
import org.springframework.beans.BeanUtils;

public class Demo {
    public static void main(String[] args) {
//        System.out.println("happy " + String.valueOf(1<<10));
        RmsSmsTemplateVo rmsSmsTemplateVo = new RmsSmsTemplateVo();
        rmsSmsTemplateVo.setcChannelId(1L);
        rmsSmsTemplateVo.setcGoodsTpye(1L);
        rmsSmsTemplateVo.setcId(1L);
        RmsSmsTemplate rmsSmsTemplate = new RmsSmsTemplate();
        BeanUtils.copyProperties(rmsSmsTemplateVo, rmsSmsTemplate);
        System.out.println(rmsSmsTemplateVo.toString());
    }
}
