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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/reply")
public class ReplyController extends BaseController{
    @Resource
    private IreplyService replyService;

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

}
