package com.seaboxdata.rop.api.controller;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.FeignClientConfig;
import com.seaboxdata.rop.api.vo.ApplicationTypeVo;
import com.seaboxdata.rop.api.input.ApplicationTypePageInput;
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
 * @date 2020-06-24 14:51:29
 */
@FeignClient(contextId = "ApplicationType",
        name = FeignClientConfig.NAME, configuration = FeignClientsConfiguration.class)
public interface IApplicationTypeController {

    /**
     * 分页
     */
    @GetMapping("/applicationType/page")
    PaginationResult<ApplicationTypeVo> applicationTypePage(@RequestBody ApplicationTypePageInput applicationTypePageInput);

    /**
     * 列表
     */
    @GetMapping("/applicationType/list")
    List<ApplicationTypeVo> applicationTypeList(@RequestBody ApplicationTypeVo applicationTypeVo);


    /**
     * 详细信息
     */
    @GetMapping("/applicationType/details/{appTypeId}")
    ApplicationTypeVo applicationTypeDetail(@PathVariable("appTypeId") Integer appTypeId);

    /**
     * 保存
     */
    @PostMapping("/applicationType/save")
    Boolean applicationTypeSave(@RequestBody ApplicationTypeVo applicationTypeVo);

    /**
     * 修改
     */
    @PostMapping("/applicationType/update")
    Boolean applicationTypeUpdate(@RequestBody ApplicationTypeVo applicationTypeVo);

    /**
     * 删除
     */
    @DeleteMapping("/applicationType/delete")
    Boolean applicationTypeDelete(@RequestBody Integer[] appTypeIds);

}
