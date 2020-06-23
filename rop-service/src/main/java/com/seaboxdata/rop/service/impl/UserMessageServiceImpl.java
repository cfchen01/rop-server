package com.seaboxdata.rop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seaboxdata.rop.enums.ServiceCode;
import com.seaboxdata.commons.exception.ServiceException;
import com.seaboxdata.commons.query.PaginationResult;
import com.seaboxdata.rop.mapper.UserMessageMapper;
import com.seaboxdata.rop.model.UserMessage;
import com.seaboxdata.rop.service.IUserMessageService;
import com.seaboxdata.rop.vo.UserMessageVo;
import com.seaboxdata.rop.input.UserMessagePageInput;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service("userMessageService")
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements IUserMessageService {

    @Autowired
    private UserMessageMapper mapper;

    @Override
    public PaginationResult<UserMessageVo> userMessagePage(UserMessagePageInput input) {
        if (null == input) {
            return null;
        }
        IPage<UserMessage> page = new Page<>(1 + (input.getOffset() / input.getLimit()), input.getLimit());
        IPage<UserMessage> iPage = mapper.selectPage(page, new QueryWrapper<>());
        PaginationResult<UserMessageVo> paginationResult = new PaginationResult<>();
        if (iPage == null) {
            return null;
        }
        paginationResult.setOffset((int) iPage.getCurrent());
        paginationResult.setLimit((int) iPage.getSize());
        paginationResult.setTotal((int) iPage.getTotal());
        ArrayList<UserMessageVo> userMessageVos = new ArrayList<>();
        List<UserMessage> records = iPage.getRecords();
        for (UserMessage record : records) {
            UserMessageVo vo = new UserMessageVo();
            BeanUtils.copyProperties(record, vo);
            userMessageVos.add(vo);
        }
        paginationResult.setData(userMessageVos);
        return paginationResult;
    }

    @Override
    public List<UserMessageVo> userMessageList(UserMessageVo userMessageVo) {
        if (userMessageVo == null) {
            return null;
        }
        List<UserMessage> userMessages = mapper.selectList(new QueryWrapper<>());
        ArrayList<UserMessageVo> dtos = new ArrayList<>();
        for (UserMessage userMessage : userMessages) {
            UserMessageVo vo = new UserMessageVo();
            BeanUtils.copyProperties(userMessage, vo);
            dtos.add(vo);
        }
        return dtos;
    }

    @Override
    public Boolean userMessageSave(UserMessageVo userMessageVo) {
        if (userMessageVo == null) {
            throw new ServiceException(ServiceCode.SERVICE_CODE_403, "vo" + ServiceCode.DATA_IS_EMPTY);
        }
        UserMessage userMessage = new UserMessage();
        BeanUtils.copyProperties(userMessageVo, userMessage);
        return mapper.insert(userMessage) > 0;
    }

    @Override
    public Boolean userMessageUpdate(UserMessageVo userMessageVo) {
        UserMessage name = new UserMessage();
        BeanUtils.copyProperties(userMessageVo, name);
        return mapper.updateById(name) > 0;
    }
    @Override
    public UserMessageVo userMessageDetail(Integer messageId) {
        UserMessageVo userMessageVo = new UserMessageVo();
        UserMessage userMessage = mapper.selectById(messageId);
        if (userMessage == null) {
            return null;
        }
        BeanUtils.copyProperties(userMessage, userMessageVo);
        return userMessageVo;
    }
}
