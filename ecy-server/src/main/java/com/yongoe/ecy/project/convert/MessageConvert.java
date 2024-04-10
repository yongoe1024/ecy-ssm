package com.yongoe.ecy.project.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.project.controller.vo.excel.MessageExcel;
import com.yongoe.ecy.project.controller.vo.req.MessageReq;
import com.yongoe.ecy.project.controller.vo.res.MessageRes;
import com.yongoe.ecy.project.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 留言管理 convert
 *
 * @author yongoe
 * @since 2024/02/22
 */
@Mapper(componentModel = "spring")
public interface MessageConvert {
    /**
     * entity to vo
     */
    MessageReq entity2Req(Message entity);

    MessageRes entity2Res(Message entity);

    MessageExcel entity2Excel(Message entity);

    /**
     * entity to vo List
     */
    List<MessageReq> entity2ReqList(List<Message> list);

    List<MessageRes> entity2ResList(List<Message> list);

    List<MessageExcel> entity2ExcelList(List<Message> list);

    /**
     * entity to vo Page
     */
    Page<MessageRes> entity2ResPage(Page<Message> page);

    /**
     * vo to entity
     */
    Message req2Entity(MessageReq req);

    Message excel2Entity(MessageExcel excel);

    /**
     * vo to entity List
     */
    List<Message> excel2EntityList(List<MessageExcel> list);


}