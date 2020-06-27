package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.NrdInfoResApplicationService;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationInput;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.api.controller.IInfoResApplicationController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


@Service
public class NrdInfoResApplicationServiceImpl implements NrdInfoResApplicationService {

    @Autowired
    private IInfoResApplicationController infoResApplicationController;

    @Override
    public PaginationResult<InfoResApplicationVo> infoResApplicationList(InfoResApplicationPageInput input) {
        return infoResApplicationController.infoResApplicationPage(input);
    }

    @Override
    public List<InfoResApplicationVo> infoResApplicationAll(InfoResApplicationInput infoResApplicationInput) {
        InfoResApplicationVo infoResApplicationVo = new InfoResApplicationVo();
        BeanUtils.copyProperties(infoResApplicationInput, infoResApplicationVo);
        return infoResApplicationController.infoResApplicationList(infoResApplicationVo);
    }

    @Override
    public Boolean infoResApplicationSave(InfoResApplicationInput infoResApplicationInput) {
        InfoResApplicationVo infoResApplicationVo = new InfoResApplicationVo();
        BeanUtils.copyProperties(infoResApplicationInput, infoResApplicationVo);
        infoResApplicationVo.setAppSubmitTime(new Date());
        return infoResApplicationController.infoResApplicationSave(infoResApplicationVo);
    }

    @Override
    public Boolean infoResApplicationUpdate(InfoResApplicationInput infoResApplicationInput) {
        InfoResApplicationVo infoResApplicationVo = new InfoResApplicationVo();
        BeanUtils.copyProperties(infoResApplicationInput, infoResApplicationVo);
        return infoResApplicationController.infoResApplicationUpdate(infoResApplicationVo);
    }
    @Override
    public InfoResApplicationVo infoResApplicationDetail(Integer appId) {
        return infoResApplicationController.infoResApplicationDetail(appId);
    }

    @Override
    public Boolean infoResApplicationDelete(Integer[] appIds) {
        return infoResApplicationController.infoResApplicationDelete(appIds);
    }
}
