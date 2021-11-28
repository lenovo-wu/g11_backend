package com.g11zucc.g11_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.JWT.JwtUtil;
import com.g11zucc.g11_back.common.exception.ApiAsserts;
import com.g11zucc.g11_back.mapper.userMapper;
import com.g11zucc.g11_back.model.dto.LoginDTO;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.service.IuserService;
import com.g11zucc.g11_back.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.BeanUtils;
import java.util.Date;


@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IuserServiceimpl extends ServiceImpl<userMapper, user>
        implements IuserService {


    @Override
    public user executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<user> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(user::getUserName, dto.getEmail());
        user user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("账号已存在！");
        }
        user addUser = user.builder()
                .UserId(dto.getEmail())
                .UserName(dto.getEmail())
                .UserPwd(MD5Utils.getPwd(dto.getPass()))
                .UserRegistertime(new Date())
                .UserState("正常")
                .UserJurisdiction("正常11")
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            user user = getUserByUserName(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getUserPwd()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUserName()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }
        return token;
    }


    @Override
    public user getUserByUserName(String UserName) {
        return baseMapper.selectOne(new LambdaQueryWrapper<user>().eq(user::getUserName, UserName));
    }

}
