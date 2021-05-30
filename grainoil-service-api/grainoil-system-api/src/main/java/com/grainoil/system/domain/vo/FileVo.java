package com.grainoil.system.domain.vo;

import com.grainoil.common.constant.Constants;
import lombok.Data;

import java.io.Serializable;

@Data
public class FileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fileId;

    private String fileName;

    private String show = "/dfs" + Constants.RESOURCE_PREFIX;

    private String download = "/dfs/download";

    private String url;
}
