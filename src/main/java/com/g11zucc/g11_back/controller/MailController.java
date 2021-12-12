package com.g11zucc.g11_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.g11zucc.g11_back.common.RestResponse;
import com.g11zucc.g11_back.common.api.ApiResult;
import com.g11zucc.g11_back.model.dto.EmailDTO;
import com.g11zucc.g11_back.model.dto.RegisterDTO;
import com.g11zucc.g11_back.model.entity.email;
import com.g11zucc.g11_back.model.entity.user;
import com.g11zucc.g11_back.model.entity.wall;
import com.g11zucc.g11_back.service.IemailService;
import com.g11zucc.g11_back.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)

    public RestResponse<String> getCheckCodes(@Valid @RequestBody EmailDTO dto){

        RestResponse restResponse = new RestResponse();
        //email aemail = mailService.executeInsertEmail(dto);
        log.info("进入方法getCheckCode:"+dto.getEmail().toString());
        int x = new Random().nextInt(899999) + 100000;
        email bemail = mailService.executeStoreCode(x,dto);
        String checkCode = String.valueOf(x);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(bemail.getEmail(), "注册验证码", message);
        }catch (Exception e){
            restResponse.setData(e);
            return restResponse;
        }
        restResponse.setData(checkCode);
        restResponse.setCode(200);
        restResponse.setMsg("sss");
        log.info("返回值");
        return restResponse;
    }

}