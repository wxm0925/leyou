package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/3 21:34
 * @description：启动类
 */
@SpringBootApplication
@EnableEurekaServer //eureka服务端
public class LeyouRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouRegistryApplication.class,args);
    }
}
