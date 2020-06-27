package com.seaboxdata.rop.controller;

import com.seaboxdata.rop.service.impl.IResourceEsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.IInfoResApplicationService;
import com.seaboxdata.rop.api.controller.IInfoResApplicationController;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;

import java.util.Arrays;
import java.util.List;

/**
 * 数据应用 --
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@RestController
public class InfoResApplicationController implements IInfoResApplicationController{

    @Autowired
    private IInfoResApplicationService infoResApplicationService;

    @Autowired
    private IResourceEsServiceImpl resourceEsService;

    /**
     * 分页
     */
    @Override
    public PaginationResult<InfoResApplicationVo> infoResApplicationPage(InfoResApplicationPageInput infoResApplicationPageInput){
//        return infoResApplicationService.infoResApplicationPage(infoResApplicationPageInput);

        return resourceEsService.getMsg(infoResApplicationPageInput);
    }

    /**
     * 列表
     */
    @Override
    public List<InfoResApplicationVo> infoResApplicationList(InfoResApplicationVo infoResApplicationVo){
        return infoResApplicationService.infoResApplicationList(infoResApplicationVo);
    }


    /**
     * 信息
     */
    @Override
    public InfoResApplicationVo infoResApplicationDetail(Integer appId){
		return infoResApplicationService.infoResApplicationDetail(appId);
    }

    /**
     * 保存
     */
    @Override
    public Boolean infoResApplicationSave(InfoResApplicationVo infoResApplicationVo){
//        return infoResApplicationService.infoResApplicationSave(infoResApplicationVo);
        return resourceEsService.createMsg(infoResApplicationVo);
    }

    /**
     * 修改
     */
    @Override
    public Boolean infoResApplicationUpdate(InfoResApplicationVo infoResApplicationVo){
//        return infoResApplicationService.infoResApplicationUpdate(infoResApplicationVo);
        return resourceEsService.updateMsg(infoResApplicationVo);
    }

    /**
     * 删除
     */
    @Override
    public Boolean infoResApplicationDelete(Integer[] appIds){
//		return infoResApplicationService.removeByIds(Arrays.asList(appIds));
        return resourceEsService.deleteMsg(appIds[0]);
    }

}
