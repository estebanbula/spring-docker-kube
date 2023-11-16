package com.estebanbula.mscourses.service.impl;

import com.estebanbula.mscourses.http.UserClientRest;
import com.estebanbula.mscourses.model.entity.Course;
import com.estebanbula.mscourses.model.entity.CourseUser;
import com.estebanbula.mscourses.model.pojo.User;
import com.estebanbula.mscourses.repository.CourseRepository;
import com.estebanbula.mscourses.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserClientRest httpUserClient;

    public CourseServiceImpl(CourseRepository courseRepository, UserClientRest httpUserClient) {
        this.courseRepository = courseRepository;
        this.httpUserClient = httpUserClient;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> listCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findCourse(String id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent() && !course.get().getCourseUsers().isEmpty()) {
            List<String> ids = course.get().getCourseUsers().stream().map(CourseUser::getUserId).toList();
            List<User> users = httpUserClient.listUsers(ids);
            course.get().setUsers(users);
            return course;
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(String id, Course course) {
        return courseRepository.findById(id)
                .map(current -> {
                    current.setId(id);
                    current.setName(course.getName());
                    return courseRepository.save(current);
                })
                .orElseThrow();
    }

    @Override
    @Transactional
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(String courseId, String userId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            User responseUser = httpUserClient.userDetail(userId);
            CourseUser courseUser = new CourseUser();
            courseUser.setCourseId(courseId);
            courseUser.setUserId(responseUser.getId());
            course.get().addCourseUser(courseUser);
            courseRepository.save(course.get());
            return Optional.of(responseUser);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(String courseId, User user) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            User responseUser = httpUserClient.createUser(user);
            CourseUser courseUser = new CourseUser();
            courseUser.setCourseId(courseId);
            courseUser.setUserId(responseUser.getId());
            course.get().addCourseUser(courseUser);
            courseRepository.save(course.get());
            return Optional.of(responseUser);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUserFromCourse(String courseId, String userId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            User responseUser = httpUserClient.userDetail(userId);
            CourseUser courseUser = new CourseUser();
            courseUser.setUserId(responseUser.getId());
            course.get().removeCourseUser(courseUser);
            courseRepository.save(course.get());
            return Optional.of(responseUser);
        }
        return Optional.empty();
    }
}
