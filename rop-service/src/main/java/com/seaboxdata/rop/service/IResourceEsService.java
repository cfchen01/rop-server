package com.seaboxdata.rop.service;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;

import java.util.List;

public interface IResourceEsService {

    boolean createMsg(InfoResApplicationVo infoResApplicationVo);

    boolean updateMsg(InfoResApplicationVo infoResApplicationVo);

    boolean deleteMsg(Integer id);

    PaginationResult<InfoResApplicationVo> getMsg(InfoResApplicationPageInput infoResApplicationPageInput);
}
