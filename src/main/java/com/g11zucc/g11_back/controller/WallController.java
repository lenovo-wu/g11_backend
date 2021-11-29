package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IwallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wall")
public class WallController extends  BaseController{
    @Resource
    private IwallService wallService;
    @GetMapping("/wallall")
    public ApiResult<wall> getWallall(){
        List<wall> list = wallService.list(new LambdaQueryWrapper<wall>()
                .eq(wall::getWallUserid,"31901209")); //查询学号为31901209的学生所发的表白墙
        return ApiResult.success(list.get(list.size()-1)); //返回wall表里的最后一条记录
    }
//    @GetMapping("/walltime")
//    public ApiResult<wall> getWalltime(){
//        List<wall> list = wallService.list(new LambdaQueryWrapper<wall>()
//                .select(wall::getWallTime)
//                .eq(wall::getWallUserid,"31901209")); //查询学号为31901209的学生所发表白墙时间
//        return ApiResult.success(list.get(list.size()-1)); //返回wall表里的最后一条记录
//    }
//    @GetMapping("/wallto")
//    public ApiResult<wall> getWallto(){
//        List<wall> list = wallService.list(new LambdaQueryWrapper<wall>()
//                .select(wall::getWallTo)
//                .eq(wall::getWallUserid,"31901209")); //查询学号为31901209的学生所发的表白墙的表白对象
//        return ApiResult.success(list.get(list.size()-1)); //返回wall表里的最后一条记录
//    }


}
