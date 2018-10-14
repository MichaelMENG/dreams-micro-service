package com.dreams.course;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableDubbo
public class CourseDubboServiceApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(CourseDubboServiceApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
