package com.yongoe.ecy.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yongoe.ecy.project.entity.Jilu;
import com.yongoe.ecy.project.mapper.JiluMapper;
import com.yongoe.ecy.project.service.JiluService;
import com.yongoe.ecy.system.entity.User;
import com.yongoe.ecy.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 积分记录
 *
 * @author yongoe
 * @since 2024/03/24
 */
@Service
public class JiluServiceImpl extends ServiceImpl<JiluMapper, Jilu> implements JiluService {
    @Resource
    private UserService userService;

    @Override
    public Page<Jilu> getJiluByPage(Page<Jilu> page, Jilu jilu) {
        return baseMapper.getJiluByPage(page, jilu);
    }


    @Override
    public void updateScore(String name, Integer score, String from) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getName, name));
        user.setScore(user.getScore() + score);
        userService.updateById(user);
        Jilu jilu = new Jilu();
        jilu.setUserId(user.getId());
        jilu.setDetail(from);
        jilu.setUpdateNum(score);
        jilu.setSum(user.getScore());
        baseMapper.insert(jilu);

    }


}
