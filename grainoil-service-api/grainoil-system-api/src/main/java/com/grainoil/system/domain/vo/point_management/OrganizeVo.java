package com.grainoil.system.domain.vo.point_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value = "OrganizeVo", description = "使用企业信息")
public class OrganizeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "organizeId", value = "企业id")
    private Long organizeId;

    @ApiModelProperty(name = "organizeName", value = "企业名称")
    private String organizeName;

    @ApiModelProperty(name = "organizeCreditCode", value = "统一社会信用代码")
    private String organizeCreditCode;

    @ApiModelProperty(name = "organizePosition", value = "地址")
    private String organizePosition;

    @ApiModelProperty(name = "organizeRegion", value = "所在行政区(数字字典)")
    private String organizeRegion;

    @ApiModelProperty(name = "serviceObject", value = "服务对象")
    private String serviceObject;

    @ApiModelProperty(name = "organizeType", value = "组织类型")
    private String organizeType;

    @ApiModelProperty(name = "organizePerson", value = "法人代表")
    private String organizePerson;

    @ApiModelProperty(name = "organizePhonenumber", value = "联系电话")
    private String organizePhonenumber;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "id", value = "所选负责人id")
    private String id;

    @ApiModelProperty(name = "name", value = "所选负责人名称")
    private String name;

    @ApiModelProperty(name = "userList", value = "负责人下拉列表")
    private List<Map<String, Object>> userList;
}
