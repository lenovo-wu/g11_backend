package com.g11zucc.g11_back.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.mapper.collMapper;
import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.service.IcollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IcollServiceimpl extends ServiceImpl<collMapper, collection>
        implements IcollService {
    @Resource
    private collMapper acollMapper;

    @Override
    public Page<collection> getList(Page<collection> page) {
        // 查询话题
        Page<collection> iPage = this.baseMapper.selectListAndPage(page);

        return iPage;
    }
}
