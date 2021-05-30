package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.system.domain.TbPile;
import com.grainoil.system.domain.TbPileProperty;
import com.grainoil.system.domain.vo.point_management.*;
import com.grainoil.system.mapper.*;
import com.grainoil.system.service.ITbPileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TbPileServiceImpl implements ITbPileService {

    @Autowired
    TbPileMapper pileMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbStorehouseMapper storehouseMapper;

    @Autowired
    TbPilePropertyMapper pilePropertyMapper;

    @Autowired
    TbCompanyStorageMapper companyStorageMapper;

    @Autowired
    TbGrainActualInventoryMapper grainActualInventoryMapper;

    @Autowired
    TbChildPileMapper childPileMapper;

    /**
     * 添加堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult insert(PileVo pile, CurrentUser currentUser) {
        Map<String, Object> map = verify(pile, false);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        if (pile.getStorehouseId() == null) {
            return ResponseResult.error("所属仓房不能为空");
        }
        pileMapper.insert(pile, currentUser);
        TbPileProperty tbPileProperty = new TbPileProperty();
        tbPileProperty.setParentId(pile.getId());
        tbPileProperty.setPackMethod(pile.getPackMethod());
        pilePropertyMapper.insert(tbPileProperty, currentUser);
        return ResponseResult.success();
    }

    /**
     * 修改堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult update(PileVo pile, CurrentUser currentUser) {
        TbPile tbPile = pileMapper.selectByPrimaryKey(pile.getId());
        if (tbPile == null) {
            return ResponseResult.error("堆位信息不存在");
        }
        if (!"0".equals(tbPile.getPileState())) {
            return ResponseResult.error("停用的堆位不能修改");
        }
        Map<String, Object> map = verify(pile, true);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(currentUser.getOrganizeType())) {
            pileMapper.updateByPrimaryKey(pile, currentUser);
            int insert = pilePropertyMapper.updateByPrimaryKey(pile, currentUser);
            return insert > 0 ? ResponseResult.success() : ResponseResult.error();
        } else if (OrganizeTypeEnum.REGION.getCode().equals(currentUser.getOrganizeType())) {
            Integer num = pileMapper.checkPileToOrganize(pile.getStorehouseId(), currentUser.getOrganizeId());
            if (num > 0) {
                pileMapper.updateByPrimaryKey(pile, currentUser);
                int insert = pilePropertyMapper.updateByPrimaryKey(pile, currentUser);
                return insert > 0 ? ResponseResult.success() : ResponseResult.error();
            } else {
                return ResponseResult.error("无权限修改堆位信息");
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(currentUser.getOrganizeType())) {
            Integer num = pileMapper.checkInOrganizeId(pile.getStorehouseId(), currentUser.getOrganizeId());
            Integer num2 = companyStorageMapper.checkPileUse(pile.getId(), currentUser.getOrganizeId());
            if (num > 0 || num2 > 0) {
                pileMapper.updateByPrimaryKey(pile, currentUser);
                int insert = pilePropertyMapper.updateByPrimaryKey(pile, currentUser);
                return insert > 0 ? ResponseResult.success() : ResponseResult.error();
            } else {
                return ResponseResult.error("无权限修改堆位信息");
            }
        } else {
            return ResponseResult.error("数据库数据异常");
        }
    }

    /**
     * 根据id获取堆位信息
     *
     * @param id 堆位id
     * @return 结果
     */
    @Override
    public ResponseResult<PileVo> getUpdate(Long id, Long organizeId, String organizeType) {
        PileVo pileVo = pileMapper.selectById(id);
        if (pileVo == null) {
            return ResponseResult.error("堆位信息不存在");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            return ResponseResult.success(pileVo);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            Integer num = pileMapper.checkPileToOrganize(pileVo.getStorehouseId(), organizeId);
            if (num > 0) {
                return ResponseResult.success(pileVo);
            } else {
                return ResponseResult.error("无权限查询堆位信息");
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)){
            Integer num = pileMapper.checkInOrganizeId(pileVo.getStorehouseId(), organizeId);
            Integer num2 = companyStorageMapper.checkPileUse(id, organizeId);
            if (num > 0 || num2 > 0) {
                return ResponseResult.success(pileVo);
            } else {
                return ResponseResult.error("无权限查询堆位信息");
            }
        } else {
            return ResponseResult.error("数据库数据异常");
        }
    }

    /**
     * 堆位信息列表
     *
     * @param pile 堆位信息
     * @return 列表
     */
    @Override
    public ResponseResult<List<PileListVo>> list(PileQueryVo pile, String organizeType, Long organizeId) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            List<PileListVo> list = pileMapper.select(pile);
            return ResponseResult.success(list);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            Integer num = pileMapper.checkPileToOrganize(pile.getStorehouseId(), organizeId);
            if (num > 0) {
                List<PileListVo> list = pileMapper.select(pile);
                return ResponseResult.success(list);
            } else {
                return ResponseResult.success(new ArrayList<>());
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer integer = storehouseMapper.checkInOrganize(pile.getStorehouseId(), organizeId);
            if (integer == 0) {
                List<PileListVo> list = pileMapper.list(organizeId, pile.getStorehouseId());
                return ResponseResult.success(list);
            }
            return ResponseResult.success(pileMapper.select(pile));
        } else {
            return ResponseResult.success(new ArrayList<>());
        }
    }

    /**
     * 拆堆
     *
     * @param splitDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult split(PileSplitDto splitDto, CurrentUser currentUser) {
        TbPile tbPile = pileMapper.selectByPrimaryKey(splitDto.getId());
        if (tbPile == null || !"0".equals(tbPile.getPileState())) {
            return ResponseResult.error("堆位不存在或者堆位已停用");
        }
        if (!"0".equals(tbPile.getIsSplit())) {
            return ResponseResult.error("该堆位无法拆堆");
        }
        Integer num = grainActualInventoryMapper.countByPileId(splitDto.getId());
        if (num > 0) {
            return ResponseResult.error("该堆位有实时库存,不允许拆堆");
        }
        if (splitDto.getList().size() < 2 || splitDto.getList().size() > 4) {
            return ResponseResult.error("子堆条数至少两个,至多4个");
        }
        BigDecimal bigDecimal = new BigDecimal(splitDto.getPileCapacity());
        for (ChildPileSplitDto childPileSplitDto : splitDto.getList()) {
            bigDecimal = bigDecimal.add(new BigDecimal(childPileSplitDto.getPileCapacity()).multiply(new BigDecimal(-1)));
        }
        if (bigDecimal.doubleValue() != 0) {
            return ResponseResult.error("库存容量数据错误");
        }
        pileMapper.updateSplit(splitDto, currentUser);
        childPileMapper.batchInsert(splitDto, currentUser);
        return ResponseResult.success();
    }

    /**
     * 合堆
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult combine(Long id, CurrentUser currentUser) {
        TbPile tbPile = pileMapper.selectByPrimaryKey(id);
        if (tbPile == null || !"0".equals(tbPile.getPileState())) {
            return ResponseResult.error("堆位不存在或者堆位已停用");
        }
        if ("0".equals(tbPile.getIsSplit())) {
            return ResponseResult.error("该堆位无法合堆");
        }
        Integer num = grainActualInventoryMapper.countByPileId(id);
        if (num > 0) {
            return ResponseResult.error("该堆位有实时库存,不允许合堆");
        }
        String name = pileMapper.selectByPrimaryKey(id).getPileCode().split("-")[0];
        pileMapper.updateCombine(id, name, currentUser);
        childPileMapper.batchDelete(id, currentUser);
        return ResponseResult.success();
    }

    /**
     * 能否拆堆
     *
     * @param id 堆位id
     * @return
     */
    @Override
    public ResponseResult canSplit(Long id) {
        TbPile tbPile = pileMapper.selectByPrimaryKey(id);
        if (tbPile == null || !"0".equals(tbPile.getPileState())) {
            return ResponseResult.error("堆位不存在或者堆位已停用");
        }
        if (!"0".equals(tbPile.getIsSplit())) {
            return ResponseResult.error("该堆位无法拆堆");
        }
        return ResponseResult.success();
    }

    /**
     * 验证堆位信息是否正确
     *
     * @param pile 堆位信息
     * @param b 添加/修改
     * @return 结果
     */
    private Map<String, Object> verify(PileVo pile, boolean b) {
        Integer num = pileMapper.count(pile, b);
        if (num > 0) {
            return BaseMap.getFailureMap("堆位名称或者堆位编码已存在");
        }
        Integer num2 = storehouseMapper.judge(pile.getStorehouseId());
        if (num2 == 0) {
            return BaseMap.getFailureMap("所属仓房不存在或者已停用");
        }
        return BaseMap.getSuccessMap();
    }
}
