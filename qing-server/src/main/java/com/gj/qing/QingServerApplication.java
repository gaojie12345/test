package com.gj.qing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class QingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingServerApplication.class, args);
        log.info("================= project start success ==============");
    }

}
