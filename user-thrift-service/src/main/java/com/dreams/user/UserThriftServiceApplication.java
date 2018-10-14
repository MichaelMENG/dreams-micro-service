package com.dreams.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class UserThriftServiceApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(UserThriftServiceApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
