package io.javabrains.springbootstarter.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @Autowired
    private TopicsService topicsService;  //marks it as sth that needs dependency injection


    @RequestMapping("/topics")   //by default this method is used for get request on topics
    public List<Topics> getAllTopics()
    {
       return topicsService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")    //{} used to tell that this is a variable portion
    public Topics getTopic( @PathVariable("id") String id)  //maps the path variable to the argument
    {
        return topicsService.getTopic(id);
    }

@RequestMapping(method = RequestMethod.POST, value = "/topics")  //map this function to any POST request on /topics
public void addTopic(@RequestBody Topics topics)
    {
        topicsService.addTopic(topics);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")  //map this function to any POST request on /topics
    public void updateTopic(@RequestBody Topics topics,@PathVariable String id)
    {
        topicsService.updateTopic(id, topics);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")  //map this function to any POST request on /topics
    public void deleteTopic(@PathVariable String id)
    {
        topicsService.deleteTopic(id);
    }
}
