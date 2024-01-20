package com.yongoe.ecy.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongoe.ecy.system.controller.vo.req.LogReq;
import com.yongoe.ecy.system.controller.vo.res.LogRes;
import com.yongoe.ecy.system.convert.LogConvert;
import com.yongoe.ecy.system.entity.Log;
import com.yongoe.ecy.system.service.LogService;
import com.yongoe.ecy.utils.PageUtils;
import com.yongoe.ecy.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统日志
 *
 * @author yongoe
 * @since 2023/09/19
 */
@RestController
@RequestMapping("/system/log")
public class LogController {
    @Resource
    private LogService logService;
    @Resource
    private LogConvert logConvert;

    @PostMapping("/page")
    public R page(@RequestBody LogReq req) {
        Log log = logConvert.req2Entity(req);
        Page<Log> page = logService.getLogByPage(Page.of(req.getCurrent(), req.getSize()), log);
        Page<LogRes> resPage = logConvert.entity2ResPage(page);
        return R.success().put(new PageUtils(resPage));
    }

    @PostMapping("/delete")
    public R delete() {
        logService.remove(null);
        return R.success("删除成功");
    }

}