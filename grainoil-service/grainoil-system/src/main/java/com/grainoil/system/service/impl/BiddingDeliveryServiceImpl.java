package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.page.PageView;
import com.grainoil.system.domain.TbBiddingDelivery;
import com.grainoil.system.domain.TbStorageContract;
import com.grainoil.system.domain.TbStorageContractDetailed;
import com.grainoil.system.domain.dto.BiddingDeliveryPageDto;
import com.grainoil.system.domain.dto.BiddingDeliverySaveDto;
import com.grainoil.system.domain.vo.FileVo;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryDetailVo;
import com.grainoil.system.domain.vo.storage_contract.BiddingDeliveryPageVo;
import com.grainoil.system.mapper.TbBiddingDeliveryMapper;
import com.grainoil.system.mapper.TbFileMapper;
import com.grainoil.system.mapper.TbStorageContractDetailedMapper;
import com.grainoil.system.mapper.TbStorageContractMapper;
import com.grainoil.system.service.BiddingDeliveryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/27 14:11
 */
@Service
public class BiddingDeliveryServiceImpl implements BiddingDeliveryService {

    @Autowired
    private TbBiddingDeliveryMapper biddingDeliveryMapper;

    @Autowired
    private TbStorageContractMapper storageContractMapper;

    @Autowired
    private TbFileMapper fileMapper;

    @Autowired
    private TbStorageContractDetailedMapper storageContractDetailedMapper;

    @Override
    @Transactional
    public void save(BiddingDeliverySaveDto saveDto) {
        Long id = saveDto.getId();
        //新增
        if(id == null){
            TbBiddingDelivery biddingDelivery = new TbBiddingDelivery();
            BeanUtils.copyProperties(saveDto,biddingDelivery);
            biddingDeliveryMapper.insert(biddingDelivery);
        }else{
            //更新
            TbBiddingDelivery biddingDelivery = biddingDeliveryMapper.selectByPrimaryKey(id);
            BeanUtils.copyProperties(saveDto,biddingDelivery);
            biddingDeliveryMapper.updateByPrimaryKeySelective(biddingDelivery);
        }
    }

    @Override
    public BiddingDeliveryDetailVo getStorageMessage(Long contractId) {
        BiddingDeliveryDetailVo contractMessageVo = new BiddingDeliveryDetailVo();
        TbStorageContract tbStorageContract = storageContractMapper.selectByPrimaryKey(contractId);
        FileVo contractFileVo = tbStorageContract.getFileVo();
        Long id = tbStorageContract.getId();
        List<TbStorageContractDetailed> detaileds = storageContractDetailedMapper.selectByContractId(id);
        double sum = detaileds.stream().mapToDouble(TbStorageContractDetailed::getQuantity).sum();
        contractMessageVo.setQuantity(sum);
        contractMessageVo.setContractFile(contractFileVo);
        contractMessageVo.setOrganizeName(tbStorageContract.getOrganizeName());
        contractMessageVo.setOrganizeId(tbStorageContract.getOrganizeId());
        contractMessageVo.setStorageContractId(tbStorageContract.getId());
        contractMessageVo.setStorageContractCode(tbStorageContract.getContractCode());
        return contractMessageVo;
    }

    @Override
    public PageView<BiddingDeliveryPageVo> page(BiddingDeliveryPageDto biddingDeliveryPageDto) {
        PageHelper.startPage(biddingDeliveryPageDto.getCurrent(), biddingDeliveryPageDto.getPageSize());
        List<BiddingDeliveryPageVo> pageVoList = biddingDeliveryMapper.selectPage(biddingDeliveryPageDto);
        PageInfo pageInfo = new PageInfo(pageVoList);
        return new PageView<>(pageInfo);
    }

    @Override
    public BiddingDeliveryDetailVo getBiddingDelivery(Long id) {
        TbBiddingDelivery biddingDelivery = biddingDeliveryMapper.selectByPrimaryKey(id);
        BiddingDeliveryDetailVo deliveryDetailVo = new BiddingDeliveryDetailVo();
        BeanUtils.copyProperties(biddingDelivery,deliveryDetailVo);
        Long storageContractId = biddingDelivery.getStorageContractId();
        TbStorageContract storageContract = storageContractMapper.selectByPrimaryKey(storageContractId);
        deliveryDetailVo.setOrganizeId(storageContract.getOrganizeId());
        deliveryDetailVo.setOrganizeName(storageContract.getOrganizeName());
        deliveryDetailVo.setContractFile(storageContract.getFileVo());
        deliveryDetailVo.setStorageContractId(storageContract.getId());
        deliveryDetailVo.setStorageContractCode(storageContract.getContractCode());
        if(biddingDelivery.getFileId() != null){
            FileVo fileVo = fileMapper.getFileVoById(biddingDelivery.getFileId());
            deliveryDetailVo.setFile(fileVo);
        }
        return deliveryDetailVo;
    }
}
