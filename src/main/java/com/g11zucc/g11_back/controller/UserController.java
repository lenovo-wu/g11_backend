package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import com.g11zucc.g11_back.service.impl.IuserServiceimpl;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("g11zucc/user")
public class UserController extends BaseController{
    @Resource
    private IuserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        user user = userService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map);
    }

    @GetMapping("/username")
    public ApiResult<user> getName(){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserId,"31901209")); //查询学号为31901209的学生
        return ApiResult.success(list.get(list.size()-1)); //返回user表里的最后一条记录
    }
}
