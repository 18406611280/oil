package com.grainoil.common.log;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.grainoil.common.log.aspect.OperLogAspect;
import com.grainoil.common.log.listen.LogListener;
import com.grainoil.system.feign.RemoteLogService;

import lombok.AllArgsConstructor;

@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration
{
    private final RemoteLogService logService;

    @Bean
    public LogListener sysOperLogListener()
    {
        return new LogListener(logService);
    }

    @Bean
    public OperLogAspect operLogAspect()
    {
        return new OperLogAspect();
    }
}