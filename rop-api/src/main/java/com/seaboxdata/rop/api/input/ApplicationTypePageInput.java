package com.seaboxdata.rop.api.input;

import com.seaboxdata.commons.query.PaginationQueryInput;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-24 14:51:29
 */
@Data
@Accessors(chain = true)
public class ApplicationTypePageInput extends PaginationQueryInput {
	private static final long serialVersionUID = 1L;

	/**
	*  查询关键字
	*/
	private String keyword;
}
