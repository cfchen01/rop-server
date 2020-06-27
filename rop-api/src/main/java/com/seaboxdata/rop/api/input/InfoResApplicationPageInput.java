package com.seaboxdata.rop.api.input;

import com.seaboxdata.commons.query.PaginationQueryInput;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据应用 --
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@Data
@Accessors(chain = true)
public class InfoResApplicationPageInput extends PaginationQueryInput {
	private static final long serialVersionUID = 1L;

	/**
	*  查询关键字
	*/
	private String keyword;

	private Integer appType;
}
