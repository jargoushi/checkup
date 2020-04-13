package com.devise.checkup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.devise.checkup.mapper")
public class CheckupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckupApplication.class, args);
    }

}
