package com.seaboxdata.rop.controller;

import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.FeignClientConfig;
import com.seaboxdata.rop.vo.UserMessageVo;
import com.seaboxdata.rop.input.UserMessagePageInput;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 15:55:34
 */
@FeignClient(contextId = "UserMessage",
        name = FeignClientConfig.NAME, configuration = FeignClientsConfiguration.class)
@RequestMapping("/userMessage")
public interface IUserMessageController {

    /**
     * 分页
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。分页列表")
    @GetMapping("/page")
    PaginationResult<UserMessageVo> userMessagePage(@RequestBody UserMessagePageInput userMessagePageInput);

    /**
     * 列表
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。列表")
    @GetMapping("/list")
    List<UserMessageVo> userMessageList(@RequestBody UserMessageVo userMessageVo);


    /**
     * 详细信息
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。详细信息")
    @GetMapping("/details/{messageId}")
    UserMessageVo userMessageDetail(@PathVariable("messageId") Integer messageId);

    /**
     * 保存
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。保存")
    @PostMapping("/save")
    Boolean userMessageSave(@RequestBody UserMessageVo userMessageVo);

    /**
     * 修改
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。修改")
    @PostMapping("/update")
    Boolean userMessageUpdate(@RequestBody UserMessageVo userMessageVo);

    /**
     * 删除
     */
    @ApiOperation(value = "用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。删除")
    @DeleteMapping("/delete")
    Boolean userMessageDelete(@RequestBody Integer[] messageIds);

}
