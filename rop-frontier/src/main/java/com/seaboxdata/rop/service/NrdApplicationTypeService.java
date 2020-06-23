package com.seaboxdata.rop.service;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.vo.ApplicationTypeVo;
import com.seaboxdata.rop.input.ApplicationTypePageInput;

import java.util.List;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 14:31:50
 */
public interface NrdApplicationTypeService {

    PaginationResult<ApplicationTypeVo> applicationTypeList(ApplicationTypePageInput input);

    List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeVo applicationTypeVo);

    ApplicationTypeVo applicationTypeDetail(Integer appTypeId);

    Boolean applicationTypeSave(ApplicationTypeVo applicationTypeVo);

    Boolean applicationTypeUpdate(ApplicationTypeVo applicationTypeVo);

    Boolean applicationTypeDelete(Integer[] appTypeIds);
}

