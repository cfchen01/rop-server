package com.seaboxdata.rop.model;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 数据应用 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("info_res_application")
public class InfoResApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 应用标识 -- 
	 */
	@TableId(value = "app_id")
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


}
