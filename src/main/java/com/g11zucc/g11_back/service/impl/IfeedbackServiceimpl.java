package com.g11zucc.g11_back.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.g11zucc.g11_back.mapper.feedbackMapper;
import com.g11zucc.g11_back.model.entity.feedback;
import com.g11zucc.g11_back.service.IfeedbackService;
import org.springframework.stereotype.Service;

@Service
public class IfeedbackServiceimpl extends ServiceImpl<feedbackMapper, feedback>  implements IfeedbackService{

}