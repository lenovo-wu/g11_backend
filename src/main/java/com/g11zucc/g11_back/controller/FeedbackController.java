package com.g11zucc.g11_back.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.feedback;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IfeedbackService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/feedback")
public class FeedbackController extends BaseController{
    @Resource
    private IfeedbackService feedbackService;

    @GetMapping("/findPage")
    public ApiResult<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search){
        Page<feedback> feedbackPage=feedbackService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<feedback>lambdaQuery().like(feedback::getFeedbackUserid, search));
        return ApiResult.success(feedbackPage);
    }

    @PutMapping("/update")
    public ApiResult<?> update(@RequestBody feedback f){
        f.setFeedbackState("已处理");
        feedbackService.getBaseMapper().updateById(f);
        return ApiResult.success();
    }

    @DeleteMapping("/delete/{feedbackId}")
    public ApiResult<?>deleteuser(@PathVariable Integer feedbackId){
        feedbackService.getBaseMapper().deleteById(feedbackId);
        return ApiResult.success();
    }
}
