package com.grainoil.system.domain.quality;

import com.grainoil.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class FoodStuffCheck extends BaseEntity {

    private Long id;

    private Long varietyId;

    private String variety;

    private String applyType;

    private Long organizeId;

    private String termName;

    private String standard;

    private String delFlag;

}