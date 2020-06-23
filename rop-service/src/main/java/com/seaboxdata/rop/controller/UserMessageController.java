package com.seaboxdata.rop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.service.IUserMessageService;
import com.seaboxdata.rop.controller.IUserMessageController;
import com.seaboxdata.rop.input.UserMessagePageInput;
import com.seaboxdata.rop.vo.UserMessageVo;

import java.util.Arrays;
import java.util.List;

/**
 * 用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 15:55:34
 */
@RestController
public class UserMessageController implements IUserMessageController{

    @Autowired
    private IUserMessageService userMessageService;

    /**
     * 分页
     */
    @Override
    public PaginationResult<UserMessageVo> userMessagePage(UserMessagePageInput userMessagePageInput){
        return userMessageService.userMessagePage(userMessagePageInput);
    }

    /**
     * 列表
     */
    @Override
    public List<UserMessageVo> userMessageList(UserMessageVo userMessageVo){
        return userMessageService.userMessageList(userMessageVo);
    }


    /**
     * 信息
     */
    @Override
    public UserMessageVo userMessageDetail(Integer messageId){
		return userMessageService.userMessageDetail(messageId);
    }

    /**
     * 保存
     */
    @Override
    public Boolean userMessageSave(UserMessageVo userMessageVo){
        return userMessageService.userMessageSave(userMessageVo);
    }

    /**
     * 修改
     */
    @Override
    public Boolean userMessageUpdate(UserMessageVo userMessageVo){
        return userMessageService.userMessageUpdate(userMessageVo);
    }

    /**
     * 删除
     */
    @Override
    public Boolean userMessageDelete(Integer[] messageIds){
		return userMessageService.removeByIds(Arrays.asList(messageIds));
    }

}
