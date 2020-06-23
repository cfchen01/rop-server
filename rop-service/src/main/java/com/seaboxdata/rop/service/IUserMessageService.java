package com.seaboxdata.rop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.vo.UserMessageVo;
import com.seaboxdata.rop.input.UserMessagePageInput;
import com.seaboxdata.rop.model.UserMessage;

import java.util.List;

/**
 * 用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 15:55:34
 */
public interface IUserMessageService extends IService<UserMessage> {

    PaginationResult<UserMessageVo> userMessagePage(UserMessagePageInput input);

    List<UserMessageVo> userMessageList(UserMessageVo userMessageVo);

    UserMessageVo userMessageDetail(Integer messageId);
    Boolean userMessageSave(UserMessageVo userMessageVo);

    Boolean userMessageUpdate(UserMessageVo userMessageVo);
}

