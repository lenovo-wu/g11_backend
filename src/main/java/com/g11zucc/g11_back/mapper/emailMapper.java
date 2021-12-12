package com.g11zucc.g11_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.g11zucc.g11_back.model.entity.collection;
import com.g11zucc.g11_back.model.entity.email;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface emailMapper extends BaseMapper<email> {
}