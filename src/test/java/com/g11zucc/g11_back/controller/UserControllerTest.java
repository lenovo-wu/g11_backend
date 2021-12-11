package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
class UserControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

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
    }

    @Test
    void update() {
    }

    @Test
    void deleteuser() {
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

    @Test
    void reset() {
    }
}