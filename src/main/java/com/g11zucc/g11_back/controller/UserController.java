package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.dto.LoginDTO;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private IuserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        user auser = userService.executeRegister(dto);
        if (ObjectUtils.isEmpty(auser)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", auser);
        return ApiResult.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = userService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    @GetMapping("/username")
    public ApiResult<user> getName(){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserName,System.getProperty("user.name"))); //查询学号为31901209的学生
        return ApiResult.success(list.get(list.size()-1)); //返回user表里的最后一条记录
    }


/*
    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user user = userService.getUserByUserName(username);
        Assert.notNull(user, "用户不存在");
        Page<BmsPost> page = iBmsPostService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getUserId, user.getUserId()));
        map.put("user", user);
        map.put("topics", page);
        return ApiResult.success(map);
    }*/
}
