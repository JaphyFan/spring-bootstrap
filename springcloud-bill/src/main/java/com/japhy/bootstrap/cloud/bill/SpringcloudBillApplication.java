package com.japhy.bootstrap.cloud.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringcloudBillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudBillApplication.class, args);
    }

}
