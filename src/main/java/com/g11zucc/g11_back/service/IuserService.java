package com.g11zucc.g11_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.user;

public interface IuserService extends IService<user> {
    /**
     * 注册功能
     *
     */
    user executeRegister(RegisterDTO dto);
}
