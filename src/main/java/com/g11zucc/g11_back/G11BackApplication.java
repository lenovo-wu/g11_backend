package com.g11zucc.g11_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@MapperScan("com.g11zucc.g11_back.mapper")
@SpringBootApplication
public class G11BackApplication {
    public static void main(String[] args) {
        SpringApplication.run(G11BackApplication.class, args);
    }

}
