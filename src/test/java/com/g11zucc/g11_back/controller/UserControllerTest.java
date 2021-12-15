package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.choose;
import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.model.entity.reply;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IchooseService;
import com.g11zucc.g11_back.service.IcollService;
import com.g11zucc.g11_back.service.IreplyService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private IreplyService replyService;
    @Autowired
    private IchooseService chooseService;
    @Autowired
    private IcollService collService;


    @BeforeEach
    void setUp() {

    }

    @Test
    void register() {
        Date date = new Date();
        user u=new user();
        u.setUserId("test1208");
        u.setUserName("Test");
        u.setUserPwd("123456");
        u.setUserRegistertime(date);
        u.setUserState("ZC");
        u.setUserSex("WZ");
        u.setUserJurisdiction("GLY");
        u.setUserSignature("CSYL");
        userService.getBaseMapper().insert(u);
        List<user> result=userService.list(new LambdaQueryWrapper<user>().eq(user::getUserId,"test1208"));
        if(!result.isEmpty())
            System.out.println("test1208成功注册！");
        userService.getBaseMapper().deleteById("test1208");
    }

    @Test
    void login() {
        Date date = new Date();
        user u=new user();
        u.setUserId("login207");
        u.setUserName("Test");
        u.setUserPwd(MD5Utils.getPwd("555555"));
        u.setUserRegistertime(date);
        u.setUserState("ZC");
        u.setUserSex("WZ");
        u.setUserJurisdiction("GLY");
        u.setUserSignature("CSYL");
        userService.getBaseMapper().insert(u);
        LambdaQueryWrapper<user> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user::getUserId, "login207");
        queryWrapper.eq(user::getUserPwd, MD5Utils.getPwd("555555"));
        List<user> result = userService.list(queryWrapper);
        if(!result.isEmpty())
            System.out.println("login207登录成功！");
        else System.out.println("login207登录失败！");
        userService.getBaseMapper().deleteById("login207");
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
        Date date = new Date();
        user u = new user();
        u.setUserId("31901209");
        u.setUserSignature("update编译通过！");
        userService.getBaseMapper().updateById(u);
        user user=userService.getBaseMapper().selectById("31901209");
        System.out.println(user.getUserSignature());
    }


    @Test
    void reset() {
        Date date = new Date();
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
        Date date = new Date();
        reply r=new reply();
        r.setId(208);
        r.setReplyTime(date);
        r.setReplyUserid("11111111");
        r.setReplyContent("wwooww");
        r.setReplyUsername("11");
        r.setReplyState("0");
        r.setWallId(5);
        replyService.getBaseMapper().insert(r);
        List<reply> result=replyService.list(new LambdaQueryWrapper<reply>().eq(reply::getReplyUserid,"11111111"));
        if(!result.isEmpty())
            System.out.println("通过userid获取评论信息成功！");
        else System.out.println("通过userid获取评论信息失败！");
        replyService.getBaseMapper().deleteById(r);
    }

    @Test
    void getUserByNameForChoose() {
        Date date = new Date();
        choose c=new choose();
        c.setChooseTime(date);
        c.setChooseId(10);
        c.setChooseBeuserid("12345678");
        c.setChooseUserid("87654321");
        c.setChooseState("0");
        c.setChooseWallid("5");

        chooseService.getBaseMapper().insert(c);
        List<choose> result=chooseService.list(new LambdaQueryWrapper<choose>().eq(choose::getChooseUserid,"87654321"));
        if(!result.isEmpty())
            System.out.println("通过userid获取认领信息成功！");
        else System.out.println("通过userid获取认领信息失败！");
        chooseService.getBaseMapper().deleteById(c);
    }

    @Test
    void getUserByNameForBeChoose() {
        Date date = new Date();
        choose c=new choose();
        c.setChooseTime(date);
        c.setChooseId(10);
        c.setChooseBeuserid("12345678");
        c.setChooseUserid("87654321");
        c.setChooseState("0");
        c.setChooseWallid("5");

        chooseService.getBaseMapper().insert(c);
        List<choose> result=chooseService.list(new LambdaQueryWrapper<choose>().eq(choose::getChooseBeuserid,"12345678"));
        if(!result.isEmpty())
            System.out.println("通过userid获取被认领信息成功！");
        else System.out.println("通过userid获取被认领信息失败！");
        chooseService.getBaseMapper().deleteById(c);
    }

    @Test
    void getUserByNameForColl() {
        Date date = new Date();
        collection c=new collection();
        c.setCollectionTime(date);
        c.setId(15);
        c.setCollectionUserid("12345678");
        c.setCollectionWallid("16");

        collService.getBaseMapper().insert(c);
        List<collection> result=collService.list(new LambdaQueryWrapper<collection>().eq(collection::getCollectionUserid,"12345678"));
        if(!result.isEmpty())
            System.out.println("通过userid获取收藏信息成功！");
        else System.out.println("通过userid获取收藏信息失败！");
        collService.getBaseMapper().deleteById(c);
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
    void updatepass(){
        user u = userService.getBaseMapper().selectById("11111111");
        u.setUserPwd(MD5Utils.getPwd("202020"));
        userService.getBaseMapper().updateById(u);
        LambdaQueryWrapper<user> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user::getUserId, "11111111");
        queryWrapper.eq(user::getUserPwd, MD5Utils.getPwd("202020"));
        List<user> result = userService.list(queryWrapper);
        if(!result.isEmpty())
            System.out.println("修改密码成功！ 新的密码："+u.getUserPwd());
        else System.out.println("修改密码失败！");
    }

    @Test
    void updatesign(){
        user u = userService.getBaseMapper().selectById("11111111");
        u.setUserSignature("202020");
        userService.getBaseMapper().updateById(u);
        LambdaQueryWrapper<user> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user::getUserId, "11111111");
        queryWrapper.eq(user::getUserSignature,"202020");
        List<user> result = userService.list(queryWrapper);
        if(!result.isEmpty())
            System.out.println("修改个性签名成功！ 新的签名："+u.getUserSignature());
        else System.out.println("修改个性签名失败！");
    }

}