package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.NrdApplicationTypeService;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;
import com.seaboxdata.rop.api.input.ApplicationTypeInput;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;
import com.seaboxdata.rop.api.controller.IApplicationTypeController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class NrdApplicationTypeServiceImpl implements NrdApplicationTypeService {

    @Autowired
    private IApplicationTypeController applicationTypeController;

    @Override
    public PaginationResult<ApplicationTypeVo> applicationTypeList(ApplicationTypePageInput input) {
        return applicationTypeController.applicationTypePage(input);
    }

    @Override
    public List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeInput applicationTypeInput) {
        ApplicationTypeVo applicationTypeVo = new ApplicationTypeVo();
        BeanUtils.copyProperties(applicationTypeInput, applicationTypeVo);
        return applicationTypeController.applicationTypeList(applicationTypeVo);
    }

    @Override
    public Boolean applicationTypeSave(ApplicationTypeInput applicationTypeInput) {
        ApplicationTypeVo applicationTypeVo = new ApplicationTypeVo();
        BeanUtils.copyProperties(applicationTypeInput, applicationTypeVo);
        return applicationTypeController.applicationTypeSave(applicationTypeVo);
    }

    @Override
    public Boolean applicationTypeUpdate(ApplicationTypeInput applicationTypeInput) {
        ApplicationTypeVo applicationTypeVo = new ApplicationTypeVo();
        BeanUtils.copyProperties(applicationTypeInput, applicationTypeVo);
        return applicationTypeController.applicationTypeUpdate(applicationTypeVo);
    }
    @Override
    public ApplicationTypeVo applicationTypeDetail(Integer appTypeId) {
        return applicationTypeController.applicationTypeDetail(appTypeId);
    }

    @Override
    public Boolean applicationTypeDelete(Integer[] appTypeIds) {
        return applicationTypeController.applicationTypeDelete(appTypeIds);
    }
}
