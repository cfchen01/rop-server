package com.seaboxdata.rop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;
import com.seaboxdata.rop.model.ApplicationType;

import java.util.List;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
public interface IApplicationTypeService extends IService<ApplicationType> {

    PaginationResult<ApplicationTypeVo> applicationTypePage(ApplicationTypePageInput input);

    List<ApplicationTypeVo> applicationTypeList(ApplicationTypeVo applicationTypeVo);

    ApplicationTypeVo applicationTypeDetail(Integer appTypeId);
    Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo);

    Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo);
}

