package com.estebanbula.mscourses.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses_users")
public class CourseUser {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String courseId;
    @Column(name = "user_id", unique = true)
    private String userId;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CourseUser)) return false;
        CourseUser courseUser = (CourseUser) obj;
        return this.userId != null && this.userId.equals(courseUser.userId);
    }
}
