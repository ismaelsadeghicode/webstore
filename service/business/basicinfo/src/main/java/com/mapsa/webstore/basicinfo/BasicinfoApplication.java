package com.mapsa.webstore.basicinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class BasicinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicinfoApplication.class, args);
    }

}
