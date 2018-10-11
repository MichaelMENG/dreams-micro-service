package com.dreams.course.service;

import com.dreams.course.ICourseService;
import com.dreams.course.dto.CourseDTO;
import com.dreams.course.mapper.CourseMapper;
import com.dreams.thrift.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ServiceProvider serviceProvider;

    @Override
    public List<CourseDTO> courseList() {

        List<CourseDTO> courseDTOS = courseMapper.listCourse();
        if (courseDTOS != null) {
            for (CourseDTO courseDTO : courseDTOS) {
                Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
                if (teacherId != null) {
                    try {
                        UserInfo userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
                        //courseDTO.set
                    } catch (Exception e) {
                    }
                }
            }
        }
        return null;
    }
}
