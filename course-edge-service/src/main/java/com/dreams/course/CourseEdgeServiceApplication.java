package com.dreams.course;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.dreams.course.filter.CourseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CourseEdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseEdgeServiceApplication.class, args);
    }

    // spring boot 注册 filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean(CourseFilter courseFilter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(courseFilter);

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);

        return filterRegistrationBean;
    }

}
