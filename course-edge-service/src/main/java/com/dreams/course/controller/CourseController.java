package com.dreams.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dreams.course.ICourseService;
import com.dreams.course.dto.CourseDTO;
import com.dreams.thrift.user.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Reference(version = "${course.service.version}"
//            application = "${dubbo.application.id}",
//            url = "${dubbo.registry.address}"
    )
    private ICourseService courseService;

    @GetMapping("/courseList")
    @ResponseBody
    public List<CourseDTO> courseList(HttpServletRequest request) {

        UserDTO user = (UserDTO) request.getAttribute("user");
        System.out.println(user.toString());

        return courseService.courseList();
    }
}
