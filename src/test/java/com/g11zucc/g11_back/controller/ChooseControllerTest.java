package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.RestResponse;
import com.g11zucc.g11_back.model.entity.*;
import com.g11zucc.g11_back.service.*;
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
class ChooseControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IchooseService chooseService;


    @BeforeEach
    void setUp() {
    }


    @Test
    void deletecoll(){
        Date date = new Date();
        choose c = new choose();
        c.setChooseId(15);
        c.setChooseWallid("1");
        c.setChooseTime(date);
        c.setChooseUserid("11111111");
        c.setChooseBeuserid("11111101");
        c.setChooseState("1");
        chooseService.getBaseMapper().insert(c);
        LambdaQueryWrapper<choose> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(choose::getChooseId, 15);
        List<choose> result = chooseService.list(queryWrapper);
        if(!result.isEmpty()){
            System.out.println("添加收藏信息成功！");
            chooseService.getBaseMapper().deleteById(c);
            LambdaQueryWrapper<choose> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.eq(choose::getChooseId, 15);
            List<choose> result2 = chooseService.list(queryWrapper2);
            if(!result2.isEmpty())
                System.out.println("删除收藏信息失败！");
            else System.out.println("删除收藏信息成功！");}
        else System.out.println("添加收藏信息失败！");

    }


}