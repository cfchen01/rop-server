package com.seaboxdata.rop.service;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;
import com.seaboxdata.rop.api.input.ApplicationTypeInput;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;

import java.util.List;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
public interface NrdApplicationTypeService {

    PaginationResult<ApplicationTypeVo> applicationTypeList(ApplicationTypePageInput input);

    List<ApplicationTypeVo> applicationTypeAll(ApplicationTypeInput applicationTypeInput);

    ApplicationTypeVo applicationTypeDetail(Integer appTypeId);

    Boolean applicationTypeSave(ApplicationTypeInput applicationTypeInput);

    Boolean applicationTypeUpdate(ApplicationTypeInput applicationTypeInput);

    Boolean applicationTypeDelete(Integer[] appTypeIds);
}

