package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.model.entity.feedback;
import com.g11zucc.g11_back.model.entity.reply;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IfeedbackService;
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
class FeedbackControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IfeedbackService feedbackservice;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findFeedbackPage() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/feedback/findPage");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findFeedbackPage！");
    }

//  修改表
    @Test
    void update() {
        feedback f = new feedback();
        f.setFeedbackId(1);
        f.setFeedbackContent("这是测试2");
        feedbackservice.getBaseMapper().updateById(f);
        feedback f2=feedbackservice.getBaseMapper().selectById(1);
        System.out.println(f2.getFeedbackContent());
    }

//  插入表
    @Test
    void insertFeedback() {
        feedback f = new feedback();
        f.setFeedbackTime(new Date(System.currentTimeMillis()));
        f.setFeedbackContent("这是测试");
        f.setFeedbackState("正常");
        f.setFeedbackId(1);
        f.setFeedbackTitle("飞时达");
        f.setFeedbackUserid("31901209");

        feedbackservice.getBaseMapper().insert(f);
        List<feedback> result=feedbackservice.list(new LambdaQueryWrapper<feedback>().eq(feedback::getFeedbackContent,"这是测试"));
        if(!result.isEmpty())
            System.out.println("feedback插入成功！");
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
}