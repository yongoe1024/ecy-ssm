package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.entity.Message;
import com.yongoe.ecy.project.mapper.MessageMapper;
import com.yongoe.ecy.project.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public Page<Message> getMessageByPage(Page<Message> page, Message message) {
        Page<Message> messageByPage = baseMapper.getMessageByPage(page, message);
        for (Message record : messageByPage.getRecords()) {
            Long id = record.getId();
            List<Message> messages = baseMapper.selectList(new LambdaQueryWrapper<Message>()
                    .eq(Message::getParentId, id));
            record.setChildren(messages);
        }
        return baseMapper.getMessageByPage(page, message);
    }

}
