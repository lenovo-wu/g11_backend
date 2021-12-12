package com.g11zucc.g11_back.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.common.exception.ApiAsserts;
import com.g11zucc.g11_back.mapper.emailMapper;
import com.g11zucc.g11_back.mapper.wallMapper;
import com.g11zucc.g11_back.model.dto.EmailDTO;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.email;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Slf4j
@Service
public class MailService extends ServiceImpl<emailMapper, email> implements IemailService{
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(String to,String title,String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(title);
        mailMessage.setText(content);
        javaMailSender.send(mailMessage);
        log.info("邮件发送成功");
    }


    public email executeInsertEmail(EmailDTO dto) {

        email addEmail = email.builder()
                .email(dto.getEmail())
                .build();
        baseMapper.insert(addEmail);

        return addEmail;
    }

    public email executeStoreCode(int cod,EmailDTO dto) {

        email addCode = email.builder()
                .email(dto.getEmail())
                .code(cod)
                .build();
        baseMapper.insert(addCode);

        return addCode;
    }
}
