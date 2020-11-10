package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication(scanBasePackages = {"com.**"})
@EnableScheduling
public class RunAdmin {
    public static void main(String[] args) {
        SpringApplication.run(RunAdmin.class, args);
    }
}
