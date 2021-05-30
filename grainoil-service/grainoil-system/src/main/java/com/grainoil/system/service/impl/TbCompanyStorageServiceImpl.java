package com.grainoil.system.service.impl;

import com.grainoil.system.mapper.TbCompanyStorageMapper;
import com.grainoil.system.service.ITbCompanyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author song
 * @date create in 21/5/22 9:08
 */
@Service
public class TbCompanyStorageServiceImpl implements ITbCompanyStorageService {

    @Autowired
    TbCompanyStorageMapper companyStorageMapper;


}
