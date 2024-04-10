package com.yongoe.ecy.project.service;

import com.yongoe.ecy.project.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 留言管理
 *
 * @author yongoe
 * @since 2024/02/22
 */
public interface MessageService extends IService<Message> {

    Page<Message> getMessageByPage(Page<Message> page, Message message);

}
