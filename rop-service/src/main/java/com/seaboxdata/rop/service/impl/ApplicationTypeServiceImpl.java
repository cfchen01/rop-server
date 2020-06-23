package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seaboxdata.rop.enums.ServiceCode;
import com.seaboxdata.commons.exception.ServiceException;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.mapper.ApplicationTypeMapper;
import com.seaboxdata.rop.model.ApplicationType;
import com.seaboxdata.rop.service.IApplicationTypeService;
import com.seaboxdata.rop.vo.ApplicationTypeVo;
import com.seaboxdata.rop.input.ApplicationTypePageInput;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service("applicationTypeService")
public class ApplicationTypeServiceImpl extends ServiceImpl<ApplicationTypeMapper, ApplicationType> implements IApplicationTypeService {

    @Autowired
    private ApplicationTypeMapper mapper;

    @Override
    public PaginationResult<ApplicationTypeVo> applicationTypePage(ApplicationTypePageInput input) {
        if (null == input) {
            return null;
        }
        IPage<ApplicationType> page = new Page<>(1 + (input.getOffset() / input.getLimit()), input.getLimit());
        IPage<ApplicationType> iPage = mapper.selectPage(page, new QueryWrapper<>());
        PaginationResult<ApplicationTypeVo> paginationResult = new PaginationResult<>();
        if (iPage == null) {
            return null;
        }
        paginationResult.setOffset((int) iPage.getCurrent());
        paginationResult.setLimit((int) iPage.getSize());
        paginationResult.setTotal((int) iPage.getTotal());
        ArrayList<ApplicationTypeVo> applicationTypeVos = new ArrayList<>();
        List<ApplicationType> records = iPage.getRecords();
        for (ApplicationType record : records) {
            ApplicationTypeVo vo = new ApplicationTypeVo();
            BeanUtils.copyProperties(record, vo);
            applicationTypeVos.add(vo);
        }
        paginationResult.setData(applicationTypeVos);
        return paginationResult;
    }

    @Override
    public List<ApplicationTypeVo> applicationTypeList(ApplicationTypeVo applicationTypeVo) {
        if (applicationTypeVo == null) {
            return null;
        }
        List<ApplicationType> applicationTypes = mapper.selectList(new QueryWrapper<>());
        ArrayList<ApplicationTypeVo> dtos = new ArrayList<>();
        for (ApplicationType applicationType : applicationTypes) {
            ApplicationTypeVo vo = new ApplicationTypeVo();
            BeanUtils.copyProperties(applicationType, vo);
            dtos.add(vo);
        }
        return dtos;
    }

    @Override
    public Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo) {
        if (applicationTypeVo == null) {
            throw new ServiceException(ServiceCode.SERVICE_CODE_403, "vo" + ServiceCode.DATA_IS_EMPTY);
        }
        ApplicationType applicationType = new ApplicationType();
        BeanUtils.copyProperties(applicationTypeVo, applicationType);
        return mapper.insert(applicationType) > 0;
    }

    @Override
    public Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo) {
        ApplicationType name = new ApplicationType();
        BeanUtils.copyProperties(applicationTypeVo, name);
        return mapper.updateById(name) > 0;
    }
    @Override
    public ApplicationTypeVo applicationTypeDetail(Integer appTypeId) {
        ApplicationTypeVo applicationTypeVo = new ApplicationTypeVo();
        ApplicationType applicationType = mapper.selectById(appTypeId);
        if (applicationType == null) {
            return null;
        }
        BeanUtils.copyProperties(applicationType, applicationTypeVo);
        return applicationTypeVo;
    }
}
