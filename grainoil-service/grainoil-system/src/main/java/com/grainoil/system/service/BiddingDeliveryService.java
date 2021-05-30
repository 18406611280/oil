package com.grainoil.system.service;

import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.dto.BiddingDeliveryPageDto;
import com.grainoil.system.domain.dto.BiddingDeliverySaveDto;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryDetailVo;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryPageVo;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 14:10
 */
public interface BiddingDeliveryService {

    void save(BiddingDeliverySaveDto saveDto);

    BiddingDeliveryDetailVo getStorageMessage(Long contractId);

    PageView<BiddingDeliveryPageVo> page(BiddingDeliveryPageDto biddingDeliveryPageDto);

    BiddingDeliveryDetailVo getBiddingDelivery(Long id);
}
