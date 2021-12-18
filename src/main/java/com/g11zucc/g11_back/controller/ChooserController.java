package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.*;
import com.g11zucc.g11_back.service.IchooseService;
import com.g11zucc.g11_back.service.IwallService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/choose")
public class ChooserController extends  BaseController{
    @Resource
    private IchooseService chooseService;
    @Resource
    private IwallService wallService;

    @PostMapping("/insertChoose")
    public ApiResult<?> save(@RequestBody choose c){
        c.setChooseTime(new Date(System.currentTimeMillis()));
        chooseService.getBaseMapper().insert(c);
        return ApiResult.success();
    }
    @DeleteMapping("/delete/{chooseId}")
    public ApiResult<?>deletechoose(@PathVariable int chooseId){
        chooseService.getBaseMapper().deleteById(chooseId);
        return ApiResult.success();
    }

    @DeleteMapping("/accept/{chooseId}")
    public ApiResult<?>acceptchoose(@PathVariable int chooseId){
        LambdaQueryWrapper<choose> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(choose::getChooseId, chooseId);
        System.out.println("1    "+chooseId);
        List<choose> result = chooseService.list(queryWrapper);
        result.get(0).setChooseState("已认领");
        chooseService.getBaseMapper().updateById(result.get(0));
        System.out.println("2    "+result.get(0));
        LambdaQueryWrapper<wall> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(wall::getWallId, result.get(0).getChooseWallid());
        List<wall> result2 = wallService.list(queryWrapper2);
        System.out.println("2    "+result2.get(0));
        result2.get(0).setWallState("已认领");
        wallService.getBaseMapper().updateById(result2.get(0));
        return ApiResult.success();
    }
}
