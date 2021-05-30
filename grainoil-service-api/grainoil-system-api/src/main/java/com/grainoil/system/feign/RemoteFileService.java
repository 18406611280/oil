package com.grainoil.system.feign;

import com.grainoil.common.constant.ServiceNameConstants;
import com.grainoil.system.domain.TbFile;
import com.grainoil.system.feign.factory.RemoteFileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface RemoteFileService {

    @PostMapping("file/insert")
    Map<String, Object> insert(@RequestBody TbFile tbFile);

    @GetMapping("file/find/{fileId}")
    TbFile findFileById(@PathVariable("fileId") Long fileId);
}
