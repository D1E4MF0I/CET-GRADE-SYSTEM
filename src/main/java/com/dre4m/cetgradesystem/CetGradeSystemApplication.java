package com.dre4m.cetgradesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dre4m.cetgradesystem.mapper")
public class CetGradeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CetGradeSystemApplication.class, args);
    }

}
