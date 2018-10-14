package com.dreams.course.dto;

import com.dreams.thrift.user.dto.TeacherDTO;

import java.io.Serializable;

public class CourseDTO implements Serializable {

    private int id;

    private String title;

    private String description;

    private TeacherDTO teacher;

    public CourseDTO() {
    }

    public CourseDTO(int id, String title, String description, TeacherDTO teacher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
