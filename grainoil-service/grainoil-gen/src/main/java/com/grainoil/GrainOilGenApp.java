package com.grainoil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.grainoil.system.annotation.EnableRyFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.grainoil.*.mapper")
@EnableRyFeignClients
public class GrainOilGenApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(GrainOilGenApp.class, args);
    }
}
