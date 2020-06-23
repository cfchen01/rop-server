package com.seaboxdata.rop.input;

import com.seaboxdata.commons.query.PaginationQueryInput;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 15:55:34
 */
@Data
@Accessors(chain = true)
public class UserMessagePageInput extends PaginationQueryInput {
	private static final long serialVersionUID = 1L;

	private String keyword;
}
