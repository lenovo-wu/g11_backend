package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IwallService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
class WallControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IwallService wallservice;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getWallall() {

    }
//  按时间早晚查询Wall表
    @Test
    void findPage() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/wall/findWallPage");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findPage测试成功！");
    }

    @Test
    void save() {
        wall w=new wall();
        w.setWallContent("Test测试");
        w.setWallContenttitle("test");
        w.setWallTime(new Date(System.currentTimeMillis()));
        w.setWallUserid("31901209");
        w.setWallState("正常");
        w.setWallGood(0);
        w.setWallCollection(0);
        w.setWallTalk(0);
        w.setWallReport(0);
        w.setWallTo("Test");
        wallservice.getBaseMapper().insert(w);
        List<wall> result=wallservice.list(new LambdaQueryWrapper<wall>().eq(wall::getWallContent,"Test测试"));
        if(!result.isEmpty())
            System.out.println("save成功读入数据！");
    }

    @Test
    void findPage1() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/wall/findWallPage1");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findPage测试成功！");
    }

    @Test
    void update() {
        wall w=new wall();
        w.setWallId(21);
        w.setWallContenttitle("testg11");
        wallservice.getBaseMapper().updateById(w);
        wall wall=wallservice.getBaseMapper().selectById(21);
        System.out.println(wall.getWallContenttitle());
    }

    @Test
    void upgood() {

    }
//    按热度值查询Wall表
    @Test
    void findHotWallPage() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/wall/findHotWallPage");
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
    void insertWall() {
        wall w = new wall();
        w.setWallGood(0);
        w.setWallContent("test");
        w.setWallId(1);
        w.setWallTime(new Date(System.currentTimeMillis()));
        w.setWallContenttitle("test");
        w.setWallCollection(0);
        w.setWallTalk(0);
        w.setWallTo("asdasdasd");
        w.setWallReport(0);
        w.setWallUserid("notexist");
        w.setWallState("正常");
        wallservice.getBaseMapper().insert(w);
        List<wall> result=wallservice.list(new LambdaQueryWrapper<wall>().eq(wall::getWallUserid,"notexist"));
        if(!result.isEmpty())
            System.out.println("wall插入成功！");
    }
//    按点赞数查询Wall表
    @Test
    void findWallPage6() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/wall/findWallPage6");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findPage测试成功！");
    }

//    按收藏数查询Wall表
    @Test
    void findWallPage9() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://127.0.0.1:8000/wall/findWallPage9");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("findPage测试成功！");
    }


    @Test
    void deletewall() {
        wallservice.getBaseMapper().deleteById(15);
    }
}