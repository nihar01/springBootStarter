package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topics.Topics;
import io.javabrains.springbootstarter.topics.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class CourseService {



        @Autowired
        private CourseRepository courseRepository;

        private List<Course> courses= new ArrayList<>(Arrays.asList(
                new Course("01","MML", "Maths for machine learning"),
                new Course("02","SPE","Software production engineering")
        ));

        public List<Course> getAllCourse()
        {
//        return topics;
            List<Course> course=new ArrayList<>();
            courseRepository.findAll().forEach (courses:: add);
            return course;

        }


        public Course getCourse(String id)
        {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

            Optional<Course> course_get= courseRepository.findById(id);

//        if(topic_get.isPresent())
            return course_get.get();

        }

        public void addCourse(Course course)
        {
            courseRepository.save(course);
        }
        public void updateCourse(String id, Course course)
        {
//        for(int i=0;i<topics.size();i++)
//        {
//            Topics t=topics.get(i);
//            if(t.getId().equals(id))
//            {
//                topics.set(i,topic);
//                return;
//            }
//
//        }

            courseRepository.save(course);
            //.save will do update if the row is already existing.
        }

        public void deleteCourse(String id)
        {
//topics.removeIf(t-> t.getId().equals(id));
            courseRepository.deleteById(id);
        }

    }

