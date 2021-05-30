package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.common.enums.RoleEnum;
import com.grainoil.common.enums.StoreTypeEnum;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.system.domain.TbStorehouse;
import com.grainoil.system.domain.vo.point_management.*;
import com.grainoil.system.mapper.*;
import com.grainoil.system.service.ITbStorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TbStorehouseServiceImpl implements ITbStorehouseService {

    @Autowired
    TbStorehouseMapper storehouseMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbGrainDepotMapper grainDepotMapper;

    @Autowired
    TbCompanyStorageMapper companyStorageMapper;

    @Autowired
    TbUserMapper userMapper;

    @Autowired
    TbManStorageMapper manStorageMapper;

    /**
     * 添加仓房信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    @Override
    public ResponseResult insert(StorehouseVo storehouse, CurrentUser currentUser) {
        Map<String, Object> map = verify(storehouse, false);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        int insert = storehouseMapper.insert(storehouse, currentUser);
        return insert > 0 ? ResponseResult.success() : ResponseResult.error();
    }

    /**
     * 根据条件查询仓房列表信息
     *
     * @param storehouse 仓房信息
     * @param organizeId 组织id
     * @return 结果
     */
    @Override
    public ResponseResult<List<StorehouseListVo>> list(StorehouseQuery storehouse, String organizeType, Long organizeId) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            List<StorehouseListVo> list = storehouseMapper.select(storehouse, null);
            return ResponseResult.success(list);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            List<StorehouseListVo> list = storehouseMapper.select(storehouse, organizeId);
            return ResponseResult.success(list);
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer num = grainDepotMapper.getRelation(storehouse.getGrainDepotId(), organizeId);
            if (num > 0) {
                List<StorehouseListVo> list = storehouseMapper.select(storehouse, null);
                list.forEach(e -> e.setType("我的"));
                return ResponseResult.success(list);
            }
            List<StorehouseListVo> list = storehouseMapper.select2(storehouse, organizeId);
            return ResponseResult.success(list);
        } else {
            return ResponseResult.success(new ArrayList<>());
        }
    }

    /**
     * 修改仓房信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult update(StorehouseVo storehouse, CurrentUser currentUser) {
        TbStorehouse tbStorehouse = storehouseMapper.selectByPrimaryKey(storehouse.getStorehouseId());
        if (tbStorehouse == null) {
            return ResponseResult.error("仓房信息不存在");
        }
        if (!"0".equals(tbStorehouse.getStorehouseState())) {
            return ResponseResult.error("停用的仓房不能修改");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(currentUser.getOrganizeType())) {
            Map<String, Object> verify = verify(storehouse, true);
            if (verify.get("success").equals(false)) {
                return ResponseResult.error(verify.get("msg") + "");
            }
            int i = storehouseMapper.updateByPrimaryKey(storehouse, currentUser);
            return i > 0 ? ResponseResult.success() : ResponseResult.error();
        } else if (OrganizeTypeEnum.REGION.getCode().equals(currentUser.getOrganizeType())) {
            Integer num = grainDepotMapper.checkGrainDepotToOrganize(storehouse.getGrainDepotId(), currentUser.getOrganizeId());
            if (num > 0) {
                Map<String, Object> verify = verify(storehouse, true);
                if (verify.get("success").equals(false)) {
                    return ResponseResult.error(verify.get("msg") + "");
                }
                int i = storehouseMapper.updateByPrimaryKey(storehouse, currentUser);
                return i > 0 ? ResponseResult.success() : ResponseResult.error();
            } else {
                return ResponseResult.error("无权限进行操作");
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(currentUser.getOrganizeType())) {
            Integer integer = storehouseMapper.checkInOrganize(storehouse.getStorehouseId(), currentUser.getOrganizeId());
            Integer num = companyStorageMapper.checkStorehouseUse(storehouse.getStorehouseId(), currentUser.getOrganizeId());
            if (integer != 0 || num != 0) {
                // 不能删的前端没传递的组织id
                List<Long> list = new ArrayList<>();
                if (integer != 0) {
                    storehouseMapper.update(storehouse, currentUser);
                    if (storehouse.getOrganizeIds() == null) {
                        return ResponseResult.error("使用企业参数错误");
                    }
                    // 不能删的有实时库存的组织id
                    List<Long> longs = companyStorageMapper.hasInventory(currentUser.getOrganizeId(), StoreTypeEnum.STOREHOUSE.getCode());
                    for (Long aLong : longs) {
                        boolean flag = false;
                        for (Long aLong1 : storehouse.getOrganizeIds()) {
                            if (aLong.equals(aLong1)) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            list.add(aLong);
                        }
                    }
                    companyStorageMapper.deleteNotIn(list, storehouse.getStorehouseId(), StoreTypeEnum.STOREHOUSE.getCode(), currentUser);
                    if (storehouse.getOrganizeIds().size() > 0) {
                        companyStorageMapper.batchInsert(storehouse.getOrganizeIds(), storehouse.getStorehouseId(), StoreTypeEnum.STOREHOUSE.getCode(), currentUser);
                    }
                }
                if (num != 0) {
                    if (storehouse.getPersonIds() == null) {
                        throw new BusinessException("仓库管理员参数错误");
                    }
                    if (storehouse.getOrganizeIds().contains(currentUser.getOrganizeId())) {
                        if (storehouse.getPersonIds().size() == 0) {
                            throw new BusinessException("仓库管理员参数错误");
                        }
                    } else {
                        if (storehouse.getPersonIds().size() != 0) {
                            throw new BusinessException("仓库管理员参数错误");
                        }
                    }
                    Integer i = userMapper.checkUserIds(currentUser.getOrganizeId(), Long.parseLong(RoleEnum.COMPANY_STOREHOUSE_PRINCIPAL.getCode()), storehouse.getPersonIds());
                    if (storehouse.getPersonIds().size() != i) {
                        throw new BusinessException("仓库保管员参数错误");
                    } else {
                        List<Long> userIds = userMapper.getUserIds(currentUser.getOrganizeId(), Long.parseLong(RoleEnum.COMPANY_STOREHOUSE_PRINCIPAL.getCode()));
                        manStorageMapper.delete(userIds, storehouse.getStorehouseId(), StoreTypeEnum.STOREHOUSE.getCode(), currentUser);
                        if (storehouse.getPersonIds().size() > 0) {
                            manStorageMapper.batchInsert(storehouse.getPersonIds(), storehouse.getStorehouseId(), StoreTypeEnum.STOREHOUSE.getCode(), currentUser);
                        }
                    }
                }
                if (list.size() == 0) {
                    return ResponseResult.success();
                } else {
                    List<String> names = organizeMapper.getNamebyIds(list);
                    String message = "";
                    for (String name : names) {
                        if (!"".equals(message)) {
                            message += ",";
                        }
                        message += name;
                    }
                    return ResponseResult.error("组织" + message + "还有库存,删除失败!");
                }
            } else {
                return ResponseResult.error("无权限进行操作");
            }
        } else {
            throw new BusinessException("无权限进行操作");
        }
    }

    /**
     * 根据仓房id获取仓房信息
     *
     * @param id 仓房id
     * @return 结果
     */
    @Override
    public ResponseResult<StorehouseGet> getUpdate(Long id, String organizeType, Long organizeId) {
        TbStorehouse tbStorehouse = storehouseMapper.selectByPrimaryKey(id);
        if (tbStorehouse == null) {
            return ResponseResult.error("获取仓房信息失败");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            return ResponseResult.success(tbStorehouse.getStorehouse());
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            Integer integer = storehouseMapper.checkInOrganizeLq(id, organizeId);
            return integer == 0 ? ResponseResult.error("无查询该仓房信息的权限") : ResponseResult.success(tbStorehouse.getStorehouse());
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer integer = storehouseMapper.checkInOrganize(id, organizeId);
            Integer num = companyStorageMapper.checkStorehouseUse(id, organizeId);
            if (integer != 0 || num != 0) {
                List<OrganizeVo> list = companyStorageMapper.getUseCompanies2(id);
                if (num != 0) {
                    List<Map<String, Object>> userList = userMapper.findStorehouse(organizeId);
                    for (OrganizeVo vo : list) {
                        if (organizeId.equals(vo.getOrganizeId())) {
                            vo.setUserList(userList);
                            break;
                        }
                    }
                }
                StorehouseGet storehouse = tbStorehouse.getStorehouse();
                storehouse.setOrganizeVoList(list);
                return ResponseResult.success(storehouse);
            } else {
                return ResponseResult.error("无查询该仓房信息的权限");
            }
        } else {
            return ResponseResult.error("数据库数据错误");
        }
    }

    /**
     * 根据粮库id查询仓房列表
     *
     * @param grainDepotId 粮库id
     * @param organizeType 组织类型
     * @param organizeId 组织id
     * @return 仓房列表
     */
    @Override
    public List<Map<String, Object>> search(Long grainDepotId, String organizeType, Long organizeId) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            return storehouseMapper.search(grainDepotId);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            Integer num = grainDepotMapper.checkGrainDepotToOrganize(grainDepotId, organizeId);
            if (num > 0) {
                return storehouseMapper.search(grainDepotId);
            } else {
                return new ArrayList<>();
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer num = grainDepotMapper.getRelation(grainDepotId, organizeId);
            if (num > 0) {
                return storehouseMapper.search(grainDepotId);
            }
            return storehouseMapper.search2(grainDepotId, organizeId);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 验证仓房信息是否正确
     *
     * @param storehouse 仓房信息
     * @param b 添加/修改
     * @return 结果
     */
    private Map<String, Object> verify(StorehouseVo storehouse, boolean b) {
//        if (!storehouse.getStorehouseCode().startsWith("L") || storehouse.getStorehouseCode().length() == 1) {
//            return BaseMap.getFailureMap("仓房编码错误");
//        }
//        try {
//            Integer.parseInt(storehouse.getStorehouseCode().substring(1));
//        } catch (NumberFormatException e) {
//            return BaseMap.getFailureMap("仓房编码错误");
//        }
        Integer num = grainDepotMapper.judge(storehouse.getGrainDepotId());
        if (num == 0) {
            return BaseMap.getFailureMap("所属粮库不存在或者已停用");
        }
        Integer count = storehouseMapper.count(storehouse, b);
        if (count > 0) {
            return BaseMap.getFailureMap("该粮库下的仓房编码已存在");
        }
        return BaseMap.getSuccessMap();
    }

    /**
     * 仓房所属企业修改时使用企业的添加按钮中的组织下拉框
     *
     * @param id 粮库id
     * @return 组织信息列表
     */
    @Override
    public List<OrganizeVo> getOrganizeVoSelect(Long id) {
        return companyStorageMapper.getUseCompanies(id);
    }

    /**
     * 仓房所属企业修改时使用企业的添加按钮
     *
     * @param id
     * @param organizeId
     * @return
     */
    @Override
    public List<OrganizeVo> getOrganizeVo(Long id, Long organizeId, Long organizeIds) {
        List<OrganizeVo> list = companyStorageMapper.getOrganizeVo(id, organizeId);
        List<Map<String, Object>> userList = userMapper.findStorehouse(organizeIds);
        for (OrganizeVo vo : list) {
            if (organizeIds.equals(vo.getOrganizeId())) {
                vo.setUserList(userList);
                break;
            }
        }
        return list;
    }
}
