package com.ikang.service.impl;

import com.ikang.service.AsyncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Log log = LogFactory.getLog(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");
        try{
            System.out.println("execute  ThreadPool task");
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}
