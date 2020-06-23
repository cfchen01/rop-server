package com.seaboxdata.rop.mapper;

import com.seaboxdata.rop.model.UserMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户消息 -- 使用“事件类型”和“任务类型”表示消息属于系统事件提醒还是任务提醒。
 *
 * @author ccf
 * @email 674441755@qq.com
 * @date 2020-06-23 15:55:34
 */
@Repository
public interface UserMessageMapper extends BaseMapper<UserMessage> {

}
