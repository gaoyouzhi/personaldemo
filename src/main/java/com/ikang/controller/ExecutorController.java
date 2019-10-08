package com.ikang.controller;

import com.ikang.service.AsyncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutorController {
    private static final Log log = LogFactory.getLog(ExecutorController.class);

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/getExecutorInfo")
    public String getExecutorInfo(){
        log.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        log.info("end submit");

        return "success";
    }
}
