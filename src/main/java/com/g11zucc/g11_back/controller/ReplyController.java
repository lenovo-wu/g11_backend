package com.g11zucc.g11_back.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.feedback;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.reply;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IreplyService;
import com.g11zucc.g11_back.service.IuserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController{
    @Resource
    private IreplyService replyService;
    @Resource
    private IuserService userService;

    @GetMapping("/get")
    public ApiResult<?>getreplybywallid(@RequestParam(defaultValue = "") String wallId){
        List<reply> r=replyService.list(new LambdaQueryWrapper<reply>().eq(reply::getWallId,wallId));
        return ApiResult.success(r);
    }

    @GetMapping("/findReplyPage")
    public ApiResult<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "3") Integer pageSize,
                                 @RequestParam(defaultValue = "正常") String search,
                                 @RequestParam(defaultValue = "1") Integer wallId){
        Page<reply> replyPage=replyService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<reply>lambdaQuery().eq(reply::getReplyState,search).eq(reply::getWallId,wallId).orderByAsc(reply::getReplyTime,reply::getId));
        return ApiResult.success(replyPage);
    }

    @PostMapping("/insertReply")
    public ApiResult<?> save(@RequestBody reply r){
        r.setReplyTime(new Date(System.currentTimeMillis()));
        replyService.getBaseMapper().insert(r);
        return ApiResult.success(r);
    }

    @DeleteMapping("/delete/{replyId}")
    public ApiResult<?>deletereply(@PathVariable int replyId){
        replyService.getBaseMapper().deleteById(replyId);
        return ApiResult.success();
    }
    /*获取当前用户评论*/
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
}
