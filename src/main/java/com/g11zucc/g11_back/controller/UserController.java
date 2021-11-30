package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import static com.g11zucc.g11_back.JWT.JwtUtil.USER_NAME;
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

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<user> getUser(@RequestHeader(value = USER_NAME) String userName) {
        user auser = userService.getUserByUserId(userName);
        return ApiResult.success(auser);
    }


    @GetMapping("/username")
    public ApiResult<user> getName(){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserId,"31901209"));//查询学号为31901209的学生
        return ApiResult.success(list.get(list.size()-1)); //返回user表里的最后一条记录
    }

    @GetMapping("/list")
    public ApiResult<List<user>> getList(){
        List<user> list = userService.list(new QueryWrapper<>());
        return ApiResult.success(list); //返回user表里的最后一条记录
    }

    @GetMapping("/findPage")
    public ApiResult<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search){
        Page<user> userPage=userService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<user>lambdaQuery().like(user::getUserName, search));
       return ApiResult.success(userPage);
    }

    @PostMapping("/save")
    public ApiResult<?> save(@RequestBody user u){
        userService.getBaseMapper().insert(u);
        return ApiResult.success();
    }

    @PutMapping("/update")
    public ApiResult<?> update(@RequestBody user u){
        userService.getBaseMapper().updateById(u);
        return ApiResult.success();
    }

    @DeleteMapping("/delete/{userId}")
    public ApiResult<?>deleteuser(@PathVariable String userId){
        userService.getBaseMapper().deleteById(userId);
        return ApiResult.success();
    }
}
