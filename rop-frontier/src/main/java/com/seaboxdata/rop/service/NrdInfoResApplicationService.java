package com.seaboxdata.rop.service;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationInput;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;

import java.util.List;

/**
 * 数据应用 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
public interface NrdInfoResApplicationService {

    PaginationResult<InfoResApplicationVo> infoResApplicationList(InfoResApplicationPageInput input);

    List<InfoResApplicationVo> infoResApplicationAll(InfoResApplicationInput infoResApplicationInput);

    InfoResApplicationVo infoResApplicationDetail(Integer appId);

    Boolean infoResApplicationSave(InfoResApplicationInput infoResApplicationInput);

    Boolean infoResApplicationUpdate(InfoResApplicationInput infoResApplicationInput);

    Boolean infoResApplicationDelete(Integer[] appIds);
}

