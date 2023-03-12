package org.example.brotherRecord.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//默认扫描当前包下的注解，当前包为org.example.brotherRecord.service,所以要更改默认扫描路径去扫描common包的Filter
@ComponentScan(value = "org.example.*")
public class SpringApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
