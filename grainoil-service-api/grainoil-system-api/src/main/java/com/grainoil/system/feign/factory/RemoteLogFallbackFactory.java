package com.grainoil.system.feign.factory;

import org.springframework.stereotype.Component;

import com.grainoil.system.domain.SysLogininfor;
import com.grainoil.system.domain.SysOperLog;
import com.grainoil.system.feign.RemoteLogService;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService>
{
    @Override
    public RemoteLogService create(Throwable throwable)
    {
        log.error(throwable.getMessage());
        return new RemoteLogService()
        {
            @Override
            public void insertOperlog(SysOperLog operLog)
            {
            }

            @Override
            public void insertLoginlog(SysLogininfor logininfor)
            {
            }
        };
    }
}
