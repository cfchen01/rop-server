package com.seaboxdata.rop.api.input;

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
public class InfoResApplicationInput implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 应用标识 --
	 */
	private Integer appId;

	/**
	 * 应用分类标识 --
	 */
	private Integer appTypeId;

	/**
	 * 应用名称 --
	 */
	private String appName;

	/**
	 * 应用类型 -- 0：Web应用，1：移动应用
	 */
	private Integer appType;

	/**
	 * 应用介绍 --
	 */
	private String appBrief;

	/**
	 * 应用提供方 --
	 */
	private String appProvider;

	/**
	 * 应用链接 --
	 */
	private String appUrl;

	/**
	 * 应用图标链接 --
	 */
	private String appIconUrl;

	/**
	 * 提交用户 --
	 */
	private Integer submitUserId;

	/**
	 * 审核用户 --
	 */
	private Integer authUserId;

	/**
	 * 应用提交时间 --
	 */
	private String appSubmitTime;

	/**
	 * 应用审核时间 --
	 */
	private String authTime;

	/**
	 * 应用审核状态 -- 0：未审核，1：审核通过，2：审核拒绝
	 */
	private Integer authStatus;
}
