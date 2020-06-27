package com.seaboxdata.rop.response;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据应用 -- 分页展示列表结果
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@Data
public class NrdInfoResApplicationPagination extends PaginationResult<InfoResApplicationVo> implements Serializable {

    private static final long serialVersionUID = 3471529791854206928L;

}

