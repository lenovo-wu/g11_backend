package com.g11zucc.g11_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.g11zucc.g11_back.model.entity.email;
import com.g11zucc.g11_back.model.entity.user;

public interface IemailService extends IService<email> {
    public void sendSimpleMail(String to,String title,String content);
}
