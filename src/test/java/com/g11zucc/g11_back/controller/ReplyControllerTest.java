package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.RestResponse;
import com.g11zucc.g11_back.model.entity.email;
import com.g11zucc.g11_back.model.entity.reply;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IreplyService;
import com.g11zucc.g11_back.service.IwallService;
import com.g11zucc.g11_back.service.MailService;
import com.g11zucc.g11_back.utils.MD5Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
class ReplyControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IreplyService replyService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void deletereply(){
        Date date = new Date();
        reply r = new reply();
        r.setId(108);
        r.setReplyTime(date);
        r.setReplyUserid("11111011");
        r.setReplyContent("20202020");
        r.setReplyUsername("110");
        r.setReplyState("00");
        r.setWallId(1);
        replyService.getBaseMapper().insert(r);
        LambdaQueryWrapper<reply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(reply::getId, 108);
        List<reply> result = replyService.list(queryWrapper);
        if(!result.isEmpty()){
            System.out.println("添加评论信息成功！");
            replyService.getBaseMapper().deleteById(r);
            LambdaQueryWrapper<reply> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.eq(reply::getId, 108);
            List<reply> result2 = replyService.list(queryWrapper2);
            if(!result2.isEmpty())
                System.out.println("删除评论信息失败！");
            else System.out.println("删除评论信息成功！");}
        else System.out.println("添加评论信息失败！");

    }


}