package com.estebanbula.mscourses.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CourseUserId {

    private String courseId;
    private String userId;

    public CourseUserId() {
    }

    public CourseUserId(String courseId, String userId) {
        this.courseId = courseId;
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
