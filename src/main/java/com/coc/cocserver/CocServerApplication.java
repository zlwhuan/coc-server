package com.coc.cocserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CocServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocServerApplication.class, args);
    }

}
