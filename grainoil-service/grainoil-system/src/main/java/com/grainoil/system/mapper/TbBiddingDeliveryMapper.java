package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbBiddingDelivery;
import com.grainoil.system.domain.dto.BiddingDeliveryPageDto;
import com.grainoil.system.domain.example.TbBiddingDeliveryExample;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBiddingDeliveryMapper {
    long countByExample(TbBiddingDeliveryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBiddingDelivery record);

    int insertSelective(TbBiddingDelivery record);

    List<TbBiddingDelivery> selectByExample(TbBiddingDeliveryExample example);

    TbBiddingDelivery selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBiddingDelivery record, @Param("example") TbBiddingDeliveryExample example);

    int updateByExample(@Param("record") TbBiddingDelivery record, @Param("example") TbBiddingDeliveryExample example);

    int updateByPrimaryKeySelective(TbBiddingDelivery record);

    int updateByPrimaryKey(TbBiddingDelivery record);

    void batchInsert(@Param("items") List<TbBiddingDelivery> items);

    List<BiddingDeliveryPageVo> selectPage(BiddingDeliveryPageDto biddingDeliveryPageDto);
}