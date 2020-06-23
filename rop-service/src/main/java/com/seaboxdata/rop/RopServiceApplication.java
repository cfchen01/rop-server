package com.seaboxdata.rop;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.seaboxdata.rop")
@MapperScan(value = "com.seaboxdata.rop.service.mapper", markerInterface = Mapper.class)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.seaboxdata.rop")
public class RopServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RopServiceApplication.class, args);
    }

}
