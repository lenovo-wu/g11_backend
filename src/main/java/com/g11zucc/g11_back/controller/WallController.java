package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IwallService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
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
    @GetMapping("/findWallPage")
    public ApiResult<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "1") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search){
        Page<wall> wallPage=wallService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<wall>lambdaQuery().like(wall::getWallUserid, search));
        return ApiResult.success(wallPage);
    }

    @PostMapping("/insertWall")
    public ApiResult<?> save(@RequestBody wall w){
        w.setWallTime(new Date(System.currentTimeMillis()));
        wallService.getBaseMapper().insert(w);
        return ApiResult.success();
    }
    @GetMapping("/findWallPage1")
    public ApiResult<?> findPage1(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "1") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search){
        Page<wall> wallPage=wallService.getBaseMapper().selectPage(new Page<>(pageNum,pageSize), Wrappers.<wall>lambdaQuery().like(wall::getWallContenttitle, search));
        return ApiResult.success(wallPage);
    }

    @PutMapping("/update")
    public ApiResult<?> update(@RequestBody wall w){
        wallService.getBaseMapper().updateById(w);
        return ApiResult.success();
    }

    @DeleteMapping("/delete/{wallId}")
    public ApiResult<?>deletewall(@PathVariable int wallId){
        wallService.getBaseMapper().deleteById(wallId);
        return ApiResult.success();
    }
}
