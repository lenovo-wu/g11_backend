package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.RestResponse;
import com.g11zucc.g11_back.model.entity.email;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IwallService;
import com.g11zucc.g11_back.service.MailService;
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
class MailControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MailService mailService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCheckCodes() {
        RestResponse restResponse = new RestResponse();
        //email aemail = mailService.executeInsertEmail(dto);
        System.out.println("进入方法getCheckCode:"+"31901208@stu.zucc.edu.cn");
        int x = new Random().nextInt(899999) + 100000;
        email em = new email();
        em.setCode(x);
        em.setEmail("31901208@stu.zucc.edu.cn");
        String checkCode = String.valueOf(x);
        String message = "您的注册验证码为："+checkCode;
        mailService.getBaseMapper().insert(em);
        try {
            System.out.println(message+"   "+"成功");
            //mailService.sendSimpleMail(em.getEmail(), "注册验证码", message);
        }catch (Exception e){
            restResponse.setData(e);
        }
    }


}