package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import com.g11zucc.g11_back.utils.MD5Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.net.URI;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
class UserControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IuserService userService;


    @BeforeEach
    void setUp() {

    }

    @Test
    void register() {
    }

    @Test
    void login() {
    }

    @Test
    void getUser() {
    }

    @Test
    void getInfo() {
    }

    @Test
    void getlist() {
    }

    @Test
    void getuser() {
    }

    @Test
    void getName() {
    }

    @Test
    void getList() {
    }

    @Test
    void save() {
        userService.getBaseMapper().deleteById("testg12");
        Date date = new Date();
        user u=new user();
        u.setUserId("testg12");
        u.setUserName("Test");
        u.setUserPwd("123456");
        u.setUserRegistertime(date);
        u.setUserState("ZC");
        u.setUserSex("WZ");
        u.setUserJurisdiction("GLY");
        u.setUserSignature("CSYL");
        userService.getBaseMapper().insert(u);
        List<user> result=userService.list(new LambdaQueryWrapper<user>().eq(user::getUserId,"testg12"));
        if(!result.isEmpty())
            System.out.println("save成功读入数据！");
    }

    @Test
    void update() {
        user u = new user();
        u.setUserId("31901209");
        u.setUserSignature("update编译通过！");
        userService.getBaseMapper().updateById(u);
        user user=userService.getBaseMapper().selectById("31901209");
        System.out.println(user.getUserSignature());
    }


    @Test
    void reset() {
        user u = new user();
        u.setUserId("testg12");
        u.setUserPwd(MD5Utils.getPwd("123456"));
        userService.getBaseMapper().updateById(u);
        List<user> result=userService.list(new LambdaQueryWrapper<user>().eq(user::getUserId,"testg12"));
        System.out.println(result.get(0).getUserPwd());
    }

    @Test
    void deleteuser() {
        userService.getBaseMapper().deleteById("testg12");
    }

    @Test
    void getuser1() {
    }

    @Test
    void getUserByName() {
    }

    @Test
    void getUserByNameForReply() {
    }

    @Test
    void getUserByNameForChoose() {
    }

    @Test
    void getUserByNameForBeChoose() {
    }

    @Test
    void getUserByNameForColl() {
    }

    @Test
    void findPage1() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/user/findPage");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
       System.out.println("findPage测试成功！");
    }

}