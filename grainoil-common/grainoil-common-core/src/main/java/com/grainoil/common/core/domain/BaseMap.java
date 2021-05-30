package com.grainoil.common.core.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证前端传递对象正确性的基础Map
 */
public class BaseMap implements Serializable {

    private static final long   serialVersionUID = 1L;

    public static Map<String, Object> getSuccessMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("msg", "验证成功");
        return map;
    }

    public static Map<String, Object> getFailureMap(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("msg", msg);
        return map;
    }
}
