package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.NrdApplicationTypeService;
import com.seaboxdata.rop.vo.ApplicationTypeVo;
import com.seaboxdata.rop.input.ApplicationTypePageInput;
import com.seaboxdata.rop.controller.IApplicationTypeController;

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
    public List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeVo applicationTypeVo) {
        return applicationTypeController.applicationTypeList(applicationTypeVo);
    }

    @Override
    public Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo) {
        return applicationTypeController.applicationTypeSave(applicationTypeVo);
    }

    @Override
    public Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo) {
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
