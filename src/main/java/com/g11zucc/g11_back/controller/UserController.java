package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Resource
    private IuserService userService;

    @GetMapping("/username")
    public ApiResult<user> getName(){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserId,"31901209")); //查询学号为31901209的学生
        return ApiResult.success(list.get(list.size()-1)); //返回user表里的最后一条记录
    }
}
