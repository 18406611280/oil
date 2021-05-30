package com.grainoil.system.feign.factory;

import com.grainoil.system.domain.TbFile;
import com.grainoil.system.feign.RemoteFileService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService> {
    @Override
    public RemoteFileService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new RemoteFileService() {

            @Override
            public Map<String, Object> insert(TbFile tbFile) {
                Map<String, Object> map = new HashMap<>();
                map.put("insert", 0);
                map.put("id", null);
                return map;
            }

            @Override
            public TbFile findFileById(Long fileId) {
                return null;
            }
        };
    }
}
