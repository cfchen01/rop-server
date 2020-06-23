package com.seaboxdata.rop.model;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 14:31:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("application_type")
public class ApplicationType implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 应用分类标识 -- 
	 */
	@TableId(value = "app_type_id")
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
