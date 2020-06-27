package com.seaboxdata.rop.api.controller;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.api.FeignClientConfig;
import com.seaboxdata.rop.api.vo.InfoResApplicationVo;
import com.seaboxdata.rop.api.input.InfoResApplicationPageInput;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据应用 -- 
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-27 15:12:12
 */
@FeignClient(contextId = "InfoResApplication",
        name = FeignClientConfig.NAME, configuration = FeignClientsConfiguration.class)
public interface IInfoResApplicationController {

    /**
     * 分页
     */
    @GetMapping("/infoResApplication/page")
    PaginationResult<InfoResApplicationVo> infoResApplicationPage(@RequestBody InfoResApplicationPageInput infoResApplicationPageInput);

    /**
     * 列表
     */
    @GetMapping("/infoResApplication/list")
    List<InfoResApplicationVo> infoResApplicationList(@RequestBody InfoResApplicationVo infoResApplicationVo);


    /**
     * 详细信息
     */
    @GetMapping("/infoResApplication/details/{appId}")
    InfoResApplicationVo infoResApplicationDetail(@PathVariable("appId") Integer appId);

    /**
     * 保存
     */
    @PostMapping("/infoResApplication/save")
    Boolean infoResApplicationSave(@RequestBody InfoResApplicationVo infoResApplicationVo);

    /**
     * 修改
     */
    @PostMapping("/infoResApplication/update")
    Boolean infoResApplicationUpdate(@RequestBody InfoResApplicationVo infoResApplicationVo);

    /**
     * 删除
     */
    @DeleteMapping("/infoResApplication/delete")
    Boolean infoResApplicationDelete(@RequestBody Integer[] appIds);

}
