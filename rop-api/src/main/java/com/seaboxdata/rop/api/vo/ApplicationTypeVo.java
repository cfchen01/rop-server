package com.seaboxdata.rop.api.vo;

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
public class ApplicationTypeVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 应用分类标识 -- 
	 */
	private Integer appTypeId;

	/**
	 * 上级应用分类 -- 
	 */
	private Integer superAppTypeId;

	/**
	 * 应用分类名称 -- 
	 */
	private String appTypeName;

}
