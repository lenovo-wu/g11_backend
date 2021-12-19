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
        List<collection> result=collectionservice.list(new LambdaQueryWrapper<collection>().eq(collection::getCollectionUserid,"31901209").eq(collection::getCollectionWallid,5));
        if(!result.isEmpty())
            System.out.println("reply插入成功！");
    }


}