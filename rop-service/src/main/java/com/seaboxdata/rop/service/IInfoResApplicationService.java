package com.seaboxdata.rop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.model.InfoResApplication;

import java.util.List;

/**
 * 数据应用 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
public interface IInfoResApplicationService extends IService<InfoResApplication> {

    PaginationResult<InfoResApplicationVo> infoResApplicationPage(InfoResApplicationPageInput input);

    List<InfoResApplicationVo> infoResApplicationList(InfoResApplicationVo infoResApplicationVo);

    InfoResApplicationVo infoResApplicationDetail(Integer appId);
    Boolean infoResApplicationSave(InfoResApplicationVo infoResApplicationVo);

    Boolean infoResApplicationUpdate(InfoResApplicationVo infoResApplicationVo);
}

