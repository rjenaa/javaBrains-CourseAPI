package com.example.courseapi.course.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CourseRepository courseRepository;

//    List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framkework", "Description"),
//            new Topic("java", "Core Java", "Description"),
//            new Topic("javascript", "Javascript", "Description")
//    ));

    public List<Course> getAllCourses(String topicId){
       List<Course> courses = new ArrayList<>();
       courseRepository.findByTopicId(topicId).forEach(courses::add);
       return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    public void addTopic(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course topic){
     courseRepository.save(topic);
    }


    public void deleteTopic(String id, Course topic) {
        courseRepository.delete(topic);
    }
}
