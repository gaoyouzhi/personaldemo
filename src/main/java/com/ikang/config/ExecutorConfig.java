package com.ikang.config;

import com.ikang.executor.VisableThreadPoolExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Log log = LogFactory.getLog(ExecutorConfig.class);

    @Bean
    public Executor asyncServiceExecutor(){
        log.info("start config asyncServiceExecutor");
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        VisableThreadPoolExecutor taskExecutor = new VisableThreadPoolExecutor();//新增日志监控线程执行情况功能
        //配置核心线程数
        taskExecutor.setCorePoolSize(5);
        //配置最大线程数
        taskExecutor.setMaxPoolSize(5);
        //配置队列大小
        taskExecutor.setQueueCapacity(99999);
        //配置线程名称前缀
        taskExecutor.setThreadNamePrefix("async-service-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //初始化
        taskExecutor.initialize();

        return taskExecutor;
    }

}
