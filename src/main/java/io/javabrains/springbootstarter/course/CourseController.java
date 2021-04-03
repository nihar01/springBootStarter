package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topics.Topics;
import io.javabrains.springbootstarter.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CourseController {

        @Autowired
        private CourseService courseService;  //marks it as sth that needs dependency injection


        @RequestMapping("/topics/{id}/course")   //by default this method is used for get request on topics
        public List<Course> getAllCourse()
        {
            return courseService.getAllCourse();
        }


        @RequestMapping("/topics/{topicId}/course/{id}")    //{} used to tell that this is a variable portion
        public Course getCourse( @PathVariable("id") String id)  //maps the path variable to the argument
        {
            return courseService.getCourse(id);
        }


        @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course/{id}")  //map this function to any POST request on /topics
        public void addCourse(@RequestBody Course course)
        {
            courseService.addCourse(course);
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{id}")  //map this function to any POST request on /topics
        public void updateCourse(@RequestBody Course course,@PathVariable String id)
        {
            courseService.updateCourse(id, course);
        }


        @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")  //map this function to any POST request on /topics
        public void deleteCourse(@PathVariable String id)
        {
            courseService.deleteCourse(id);
        }
    }

