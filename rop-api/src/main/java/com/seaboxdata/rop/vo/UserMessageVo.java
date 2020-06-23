package com.seaboxdata.rop.vo;

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
public class UserMessageVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 消息标识 -- 
	 */
	private Integer messageId;

	/**
	 * 消息接收方 -- 
	 */
	private Integer msgRcvUser;

	/**
	 * 消息发送方 -- 
	 */
	private Integer msgSndUser;

	/**
	 * 系统消息类型标识 -- 
	 */
	private Integer msgTypeId;

	/**
	 * 消息发送渠道标识 -- 
	 */
	private Integer msgChannelId;

	/**
	 * 已读标志 -- 0,：未读，1：已读
	 */
	private Integer msgReadFlag;

	/**
	 * 发送时间 -- 
	 */
	private Date msgSndTime;

	/**
	 * 消息正文 -- 
	 */
	private String msgText;

}
