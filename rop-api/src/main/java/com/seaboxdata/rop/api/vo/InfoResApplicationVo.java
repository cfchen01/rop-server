package com.seaboxdata.rop.api.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

/**
 * 数据应用 --
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@Data
@Accessors(chain = true)
public class InfoResApplicationVo implements Serializable {
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
	private Date appSubmitTime;

	/**
	 * 应用审核时间 --
	 */
	private Date authTime;

	/**
	 * 应用审核状态 -- 0：未审核，1：审核通过，2：审核拒绝
	 */
	private Integer authStatus;


	public static Optional<InfoResApplicationVo> readValue(String json) {
		if (StringUtils.isEmpty(json)) {
			return Optional.empty();
		}
		try {
			InfoResApplicationVo resApplicationVo = new ObjectMapper().readValue(json, InfoResApplicationVo.class);
			return Optional.of(resApplicationVo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
