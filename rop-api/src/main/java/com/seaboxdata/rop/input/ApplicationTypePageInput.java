package com.seaboxdata.rop.input;

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
 * @date 2020-06-23 14:31:50
 */
@Data
@Accessors(chain = true)
public class ApplicationTypePageInput extends PaginationQueryInput {
	private static final long serialVersionUID = 1L;

	private Integer keyword;


}
