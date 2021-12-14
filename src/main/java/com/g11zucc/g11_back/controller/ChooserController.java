package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.choose;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IchooseService;
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

    @PostMapping("/insertChoose")
    public ApiResult<?> save(@RequestBody choose c){
        c.setChooseTime(new Date(System.currentTimeMillis()));
        chooseService.getBaseMapper().insert(c);
        return ApiResult.success();
    }
    @DeleteMapping("/delete/{chooseId}")
    public ApiResult<?>deletecoll(@PathVariable int chooseId){
        chooseService.getBaseMapper().deleteById(chooseId);
        return ApiResult.success();
    }

}
