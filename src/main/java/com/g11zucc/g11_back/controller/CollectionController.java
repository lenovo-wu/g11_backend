package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.entity.choose;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IcollService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController extends  BaseController{
    @Resource
    private IcollService collectionService;

    @PostMapping("/insertCollection")
    public ApiResult<?> save(@RequestBody collection c){
        c.setCollectionTime(new Date(System.currentTimeMillis()));
        LambdaQueryWrapper<collection> lanwrapper = new LambdaQueryWrapper<>();
        lanwrapper.eq(collection::getCollectionUserid,c.getCollectionUserid())
                .eq(collection::getCollectionWallid,c.getCollectionWallid());
        List<collection> list=null;
        list= collectionService.list(lanwrapper);
        if(list.size()==0){
            collectionService.getBaseMapper().insert(c);
            return ApiResult.success();
        }
        else{
            return ApiResult.failed("重复收藏！");
        }
    }

    @DeleteMapping("/delete/{collId}")
    public ApiResult<?>deletecoll(@PathVariable int collId){
        collectionService.getBaseMapper().deleteById(collId);
        return ApiResult.success();
    }

}
