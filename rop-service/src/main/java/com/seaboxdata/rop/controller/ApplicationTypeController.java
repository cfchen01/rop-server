package com.seaboxdata.rop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.IApplicationTypeService;
import com.seaboxdata.rop.api.controller.IApplicationTypeController;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;

import java.util.Arrays;
import java.util.List;

/**
 * 应用分类 --
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
@RestController
public class ApplicationTypeController implements IApplicationTypeController{

    @Autowired
    private IApplicationTypeService applicationTypeService;

    /**
     * 分页
     */
    @Override
    public PaginationResult<ApplicationTypeVo> applicationTypePage(ApplicationTypePageInput applicationTypePageInput){
        return applicationTypeService.applicationTypePage(applicationTypePageInput);
    }

    /**
     * 列表
     */
    @Override
    public List<ApplicationTypeVo> applicationTypeList(ApplicationTypeVo applicationTypeVo){
        return applicationTypeService.applicationTypeList(applicationTypeVo);
    }


    /**
     * 信息
     */
    @Override
    public ApplicationTypeVo applicationTypeDetail(Integer appTypeId){
		return applicationTypeService.applicationTypeDetail(appTypeId);
    }

    /**
     * 保存
     */
    @Override
    public Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo){
        return applicationTypeService.applicationTypeSave(applicationTypeVo);
    }

    /**
     * 修改
     */
    @Override
    public Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo){
        return applicationTypeService.applicationTypeUpdate(applicationTypeVo);
    }

    /**
     * 删除
     */
    @Override
    public Boolean applicationTypeDelete(Integer[] appTypeIds){
		return applicationTypeService.removeByIds(Arrays.asList(appTypeIds));
    }

}
