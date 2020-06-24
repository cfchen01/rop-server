package com.seaboxdata.rop.response;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用分类 -- 分页展示列表结果
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
@Data
public class NrdApplicationTypePagination extends PaginationResult<ApplicationTypeVo> implements Serializable {

    private static final long serialVersionUID = 3471529791854206928L;

}

