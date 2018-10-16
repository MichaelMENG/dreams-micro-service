package com.dreams.course.filter;

import com.dreams.thrift.user.dto.UserDTO;
import com.dreams.user.client.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CourseFilter extends LoginFilter {

    @Value("${user.edge.service.addr}")
    private String userEdgeServiceAddr;

    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {

        request.setAttribute("user", userDTO);
    }

    @Override
    protected String userEdgeServiceAddr() {
        return userEdgeServiceAddr;
    }
}
