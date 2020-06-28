package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seaboxdata.rop.api.enums.ServiceCode;
import com.seaboxdata.commons.exception.ServiceException;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.mapper.InfoResApplicationMapper;
import com.seaboxdata.rop.model.InfoResApplication;
import com.seaboxdata.rop.service.IInfoResApplicationService;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service("infoResApplicationService")
public class InfoResApplicationServiceImpl extends ServiceImpl<InfoResApplicationMapper, InfoResApplication> implements IInfoResApplicationService {

    @Autowired
    private InfoResApplicationMapper mapper;

    @Override
    public PaginationResult<InfoResApplicationVo> infoResApplicationPage(InfoResApplicationPageInput input) {
        if (null == input) {
            return null;
        }
        IPage<InfoResApplication> page = new Page<>(1 + (input.getOffset() / input.getLimit()), input.getLimit());
        IPage<InfoResApplication> iPage = mapper.selectPage(page, new QueryWrapper<>());
        PaginationResult<InfoResApplicationVo> paginationResult = new PaginationResult<>();
        if (iPage == null) {
            return null;
        }
        paginationResult.setOffset((int) iPage.getCurrent());
        paginationResult.setLimit((int) iPage.getSize());
        paginationResult.setTotal((int) iPage.getTotal());
        ArrayList<InfoResApplicationVo> infoResApplicationVos = new ArrayList<>();
        List<InfoResApplication> records = iPage.getRecords();
        for (InfoResApplication record : records) {
            InfoResApplicationVo vo = new InfoResApplicationVo();
            BeanUtils.copyProperties(record, vo);
            infoResApplicationVos.add(vo);
        }
        paginationResult.setData(infoResApplicationVos);
        return paginationResult;
    }

    @Override
    public List<InfoResApplicationVo> infoResApplicationList(InfoResApplicationVo infoResApplicationVo) {
        if (infoResApplicationVo == null) {
            return null;
        }
        List<InfoResApplication> infoResApplications = mapper.selectList(new QueryWrapper<>());
        ArrayList<InfoResApplicationVo> dtos = new ArrayList<>();
        for (InfoResApplication infoResApplication : infoResApplications) {
            InfoResApplicationVo vo = new InfoResApplicationVo();
            BeanUtils.copyProperties(infoResApplication, vo);
            dtos.add(vo);
        }
        return dtos;
    }

    @Override
    public Boolean infoResApplicationSave(InfoResApplicationVo infoResApplicationVo) {
        if (infoResApplicationVo == null) {
            throw new ServiceException(ServiceCode.SERVICE_CODE_403, "vo" + ServiceCode.DATA_IS_EMPTY);
        }
        InfoResApplication infoResApplication = new InfoResApplication();
        BeanUtils.copyProperties(infoResApplicationVo, infoResApplication);
        return mapper.insert(infoResApplication) > 0;
    }

    @Override
    public Boolean infoResApplicationUpdate(InfoResApplicationVo infoResApplicationVo) {
        InfoResApplication infoResApplication = new InfoResApplication();
        BeanUtils.copyProperties(infoResApplicationVo, infoResApplication);
        return mapper.updateById(infoResApplication) > 0;
    }
    @Override
    public InfoResApplicationVo infoResApplicationDetail(Integer appId) {
        InfoResApplicationVo infoResApplicationVo = new InfoResApplicationVo();
        InfoResApplication infoResApplication = mapper.selectById(appId);
        if (infoResApplication == null) {
            return null;
        }
        BeanUtils.copyProperties(infoResApplication, infoResApplicationVo);
        return infoResApplicationVo;
    }
}
