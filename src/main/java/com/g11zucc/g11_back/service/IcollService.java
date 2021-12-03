package com.g11zucc.g11_back.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.g11zucc.g11_back.model.entity.collection;

public interface IcollService extends IService<collection>  {
    Page<collection> getList(Page<collection> page);
}
