package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.dto.LoginDTO;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.*;
import com.g11zucc.g11_back.service.*;
import com.g11zucc.g11_back.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
    @Resource
    private IcollService collService;
    @Resource
    private IwallService wallService;
    @Resource
    private IreplyService replyService;
    @Resource
    private IchooseService chooseService;

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

    /*返回某id用户的所有信息*/
    @GetMapping("/getInfo")
    public ApiResult<user> getInfo(@RequestParam(value= "userid") String userid ){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserId, userid ));
        return ApiResult.success(list.get(list.size()-1));
    }

    /*返回某id用户的所有信息*/
    @GetMapping("/getInfo1")
    public ApiResult<user> get(@RequestBody user u){
        user au =userService.getBaseMapper().selectById(u.getUserId());
        return ApiResult.success(au);
    }


    @GetMapping("/colllist")
    public ApiResult<Page<collection>> getlist(
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<collection> list = collService.getList(new Page<>(pageNo, pageSize));
        return ApiResult.success(list);
    }

    @GetMapping("/search")
    public ApiResult<?>getuser(@RequestParam(defaultValue = "") String userId){
        List<user> u=userService.list(new LambdaQueryWrapper<user>().eq(user::getUserId,userId));
        return ApiResult.success(u);
    }

    @GetMapping("/username")
    public ApiResult<user> getName(){
        List<user> list = userService.list(new LambdaQueryWrapper<user>()
                .eq(user::getUserName,System.getProperty("user.id"))); //查询学号为31901209的学生
        return ApiResult.success(list.get(list.size()-1)); //返回user表里的最后一条记录
    }

    @GetMapping("/list")
    public ApiResult<List<user>> getList(){
        List<user> list = userService.list(new QueryWrapper<>());
        return ApiResult.success(list);
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

    @GetMapping("/get")
    public ApiResult<?>getuser1(@RequestParam(defaultValue = "") String userId){
        List<user> u=userService.list(new LambdaQueryWrapper<user>().eq(user::getUserId,userId));
        return ApiResult.success(u);
    }

    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user auser = userService.getUserByUserId(username);
        Assert.notNull(auser, "用户不存在");
        Page<wall> page = wallService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<wall>().eq(wall::getWallUserid, auser.getUserId()));
        Page<reply> page2 = replyService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<reply>().eq(reply::getReplyUserid, auser.getUserId()));
        Page<choose> page3 = chooseService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<choose>().eq(choose::getChooseUserid, auser.getUserId()));
        map.put("user", auser);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @GetMapping("/reply/{username}")
    public ApiResult<Map<String, Object>> getUserByNameForReply(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user auser = userService.getUserByUserId(username);
        Assert.notNull(auser, "用户不存在");
        Page<reply> page = replyService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<reply>().eq(reply::getReplyUserid, auser.getUserId()));
        map.put("user", auser);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @GetMapping("/choose/{username}")
    public ApiResult<Map<String, Object>> getUserByNameForChoose(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user auser = userService.getUserByUserId(username);
        Assert.notNull(auser, "用户不存在");
        Page<choose> page = chooseService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<choose>().eq(choose::getChooseUserid, auser.getUserId()));
        map.put("user", auser);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @GetMapping("/bechoose/{username}")
    public ApiResult<Map<String, Object>> getUserByNameForBeChoose(@PathVariable("username") String username,
                                                                 @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user auser = userService.getUserByUserId(username);
        Assert.notNull(auser, "用户不存在");
        Page<choose> page = chooseService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<choose>().eq(choose::getChooseBeuserid, auser.getUserId()));
        map.put("user", auser);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @GetMapping("/coll/{username}")
    public ApiResult<Map<String, Object>> getUserByNameForColl(@PathVariable("username") String username,
                                                                 @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        user auser = userService.getUserByUserId(username);
        Assert.notNull(auser, "用户不存在");
        Page<collection> page = collService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<collection>().eq(collection::getCollectionUserid, auser.getUserId()));
        map.put("user", auser);
        map.put("topics", page);
        return ApiResult.success(map);
    }

    @GetMapping("/findPage")
    public ApiResult<Page<user>> findPage1(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "") String search){
        Page<user> userPage=userService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<user>lambdaQuery().like(user::getUserId, search));
        return ApiResult.success(userPage);
    }

    @PutMapping("/reset")
    public ApiResult<?> reset(@RequestBody user u){
        u.setUserPwd(MD5Utils.getPwd("123456"));
        userService.getBaseMapper().updateById(u);
        return ApiResult.success();
    }
}
