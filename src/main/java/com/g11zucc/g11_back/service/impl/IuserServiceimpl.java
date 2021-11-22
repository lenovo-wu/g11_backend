package com.g11zucc.g11_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.mapper.userMapper;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import org.springframework.stereotype.Service;

@Service
public class IuserServiceimpl extends ServiceImpl<userMapper, user>
        implements IuserService {
}
