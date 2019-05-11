package com.hans.lpdr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hans"})
@EnableTransactionManagement
@MapperScan(basePackages = "com.hans.lpdr.mapper")
public class LpdrApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpdrApplication.class, args);
    }

}
