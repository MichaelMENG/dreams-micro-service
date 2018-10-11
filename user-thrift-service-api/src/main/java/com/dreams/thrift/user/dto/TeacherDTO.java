package com.dreams.thrift.user.dto;

public class TeacherDTO extends UserDTO {

    private String intro;

    private String stars;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
