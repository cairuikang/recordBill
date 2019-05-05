package com.jhlc.record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@ServletComponentScan(basePackages = "com.jhlc.record")
public class RecordApp {

    public static void main(String[] args) {
        SpringApplication.run(RecordApp.class, args);
    }

}
