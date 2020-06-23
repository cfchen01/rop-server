package com.seaboxdata.rop.input;

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
public class ApplicationTypeInput implements Serializable {
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
