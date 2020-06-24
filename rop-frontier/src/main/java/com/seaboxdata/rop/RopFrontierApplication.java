package com.seaboxdata.rop;


import com.coxautodev.graphql.tools.SchemaParserOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author chencaifeng
 * @date 2020-06-22 15:35
 */
@SpringBootApplication
@EnableFeignClients("com.seaboxdata")
@EnableDiscoveryClient
public class RopFrontierApplication {

    public static void main(String[] args) {
        SpringApplication.run(RopFrontierApplication.class, args);
    }

    @Bean
    public SchemaParserOptions schemaParserOptions() {
        //临时设置，允许graphql不强制所有resolver均提供实现
        return SchemaParserOptions.newOptions()
                .allowUnimplementedResolvers(true).build();
    }
}
