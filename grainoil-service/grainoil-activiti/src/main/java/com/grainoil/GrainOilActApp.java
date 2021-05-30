package com.grainoil;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.grainoil.system.annotation.EnableRyFeignClients;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("com.grainoil.*.mapper")
@EnableRyFeignClients
public class GrainOilActApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(GrainOilActApp.class, args);
    }
}
