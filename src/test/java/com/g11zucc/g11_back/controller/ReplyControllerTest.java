package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.g11zucc.g11_back.model.entity.reply;
import com.g11zucc.g11_back.service.IreplyService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class ReplyControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IreplyService replyservice;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findReplyPage() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/reply/findReplyPage");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findPage测试成功！");
    }


    //  插入表
    @Test
    void insertReply() {
        reply r = new reply();
        r.setReplyTime(new Date(System.currentTimeMillis()));
        r.setWallId(1);
        r.setReplyContent("恶作剧的对象是你哦");
        r.setId(1);
        r.setReplyState("正常");
        r.setReplyUserid("31901209");
        r.setReplyUsername("这是测试");
        replyservice.getBaseMapper().insert(r);
        List<reply> result=replyservice.list(new LambdaQueryWrapper<reply>().eq(reply::getReplyUsername,"这是测试"));
        if(!result.isEmpty())
            System.out.println("reply插入成功！");
    }

    @Test
    void getReplyByWallId() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/reply/get?wallId=1");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("getReplyByWallId测试成功！");
    }
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
        replyservice.getBaseMapper().insert(r);
        LambdaQueryWrapper<reply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(reply::getId, 108);
        List<reply> result = replyservice.list(queryWrapper);
        if(!result.isEmpty()){
            System.out.println("添加评论信息成功！");
            replyservice.getBaseMapper().deleteById(r);
            LambdaQueryWrapper<reply> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.eq(reply::getId, 108);
            List<reply> result2 = replyservice.list(queryWrapper2);
            if(!result2.isEmpty())
                System.out.println("删除评论信息失败！");
            else System.out.println("删除评论信息成功！");}
        else System.out.println("添加评论信息失败！");

    }


}