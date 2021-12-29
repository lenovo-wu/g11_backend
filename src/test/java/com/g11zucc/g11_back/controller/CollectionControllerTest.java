package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.service.IcollService;
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
class CollectionControllerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IcollService collectionservice;

    @Autowired
    private IcollService collService;


    @BeforeEach
    void setUp() {
    }


    //  插入表
    @Test
    void insertCollection() {
        collection c = new collection();
        c.setId(1);
        c.setCollectionUserid("31901209");
        c.setCollectionWallid("5");
        c.setCollectionTime(new Date(System.currentTimeMillis()));
        collectionservice.getBaseMapper().insert(c);
        List<collection> result = collectionservice.list(new LambdaQueryWrapper<collection>().eq(collection::getCollectionUserid, "31901209").eq(collection::getCollectionWallid, 5));
        if (!result.isEmpty())
            System.out.println("reply插入成功！");
    }

    @Test
    void deletecoll() {
        Date date = new Date();
        collection c = new collection();
        c.setId(18);
        c.setCollectionWallid("1");
        c.setCollectionTime(date);
        c.setCollectionUserid("11111111");
        collService.getBaseMapper().insert(c);
        LambdaQueryWrapper<collection> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(collection::getId, 18);
        List<collection> result = collService.list(queryWrapper);
        if (!result.isEmpty()) {
            System.out.println("添加收藏信息成功！");
            collService.getBaseMapper().deleteById(c);
            LambdaQueryWrapper<collection> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.eq(collection::getId, 18);
            List<collection> result2 = collService.list(queryWrapper2);
            if (!result2.isEmpty())
                System.out.println("删除收藏信息失败！");
            else System.out.println("删除收藏信息成功！");
        } else System.out.println("添加收藏信息失败！");

    }
}
    
