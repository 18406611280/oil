package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbNotice;

public interface TbNoticeMapper {
    int insert(TbNotice record);

    TbNotice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKey(TbNotice record);
}