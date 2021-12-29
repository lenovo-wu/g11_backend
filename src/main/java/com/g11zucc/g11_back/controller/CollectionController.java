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
import com.g11zucc.g11_back.service.IuserService;
import com.g11zucc.g11_back.service.IwallService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collection")
public class CollectionController extends  BaseController{
    @Resource
    private IcollService collectionService;
    @Resource
    private IwallService wallService;
    @Resource
    private IuserService userService;
    @Resource
    private IcollService collService;

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

    /*获取当前用户收藏*/
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


}
