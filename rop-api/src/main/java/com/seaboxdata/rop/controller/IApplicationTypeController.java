package com.seaboxdata.rop.controller;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.FeignClientConfig;
import com.seaboxdata.rop.vo.ApplicationTypeVo;
import com.seaboxdata.rop.input.ApplicationTypePageInput;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应用分类 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 14:31:50
 */
@FeignClient(contextId = "ApplicationType",
        name = FeignClientConfig.NAME, configuration = FeignClientsConfiguration.class)
@RequestMapping("/applicationType")
public interface IApplicationTypeController {

    /**
     * 分页
     */
    @ApiOperation(value = "应用分类 -- 分页列表")
    @GetMapping("/page")
    PaginationResult<ApplicationTypeVo> applicationTypePage(@RequestBody ApplicationTypePageInput applicationTypePageInput);

    /**
     * 列表
     */
    @ApiOperation(value = "应用分类 -- 列表")
    @GetMapping("/list")
    List<ApplicationTypeVo> applicationTypeList(@RequestBody ApplicationTypeVo applicationTypeVo);


    /**
     * 详细信息
     */
    @ApiOperation(value = "应用分类 -- 详细信息")
    @GetMapping("/details/{appTypeId}")
    ApplicationTypeVo applicationTypeDetail(@PathVariable("appTypeId") Integer appTypeId);

    /**
     * 保存
     */
    @ApiOperation(value = "应用分类 -- 保存")
    @PostMapping("/save")
    Boolean applicationTypeSave(@RequestBody ApplicationTypeVo applicationTypeVo);

    /**
     * 修改
     */
    @ApiOperation(value = "应用分类 -- 修改")
    @PostMapping("/update")
    Boolean applicationTypeUpdate(@RequestBody ApplicationTypeVo applicationTypeVo);

    /**
     * 删除
     */
    @ApiOperation(value = "应用分类 -- 删除")
    @DeleteMapping("/delete")
    Boolean applicationTypeDelete(@RequestBody Integer[] appTypeIds);

}
