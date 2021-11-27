package com.g11zucc.g11_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.common.exception.ApiAsserts;
import com.g11zucc.g11_back.mapper.userMapper;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import com.g11zucc.g11_back.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
public class IuserServiceimpl extends ServiceImpl<userMapper, user>
        implements IuserService {


    @Override
    public user executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<user> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(user::getUserId, dto.getEmail());
        user user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("账号已存在！");
        }
        user addUser = user.builder()
                .UserId(dto.getEmail())
                .UserPwd(MD5Utils.getPwd(dto.getPass()))
                .UserRegistertime(new Date())
                .UserState(1)
                .UserJurisdiction(1)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

}
