package io.javabrains.springbootstarter.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicsService {

    @Autowired
    private TopicsRepository topicsRepository;

    private List<Topics> topics= new ArrayList<>(Arrays.asList(
            new Topics("01","MML", "Maths for machine learning"),
            new Topics("02","SPE","Software production engineering")
    ));

    public List<Topics> getAllTopics()
    {
//        return topics;
        List<Topics> topics=new ArrayList<>();
        topicsRepository.findAll().forEach (topics:: add);
        return topics;

    }


    public Topics getTopic(String id)
    {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

        Optional<Topics> topic_get= topicsRepository.findById(id);

//        if(topic_get.isPresent())
            return topic_get.get();

    }

    public void addTopic(Topics topic)
    {
topicsRepository.save(topic);
    }
    public void updateTopic(String id, Topics topic)
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

        topicsRepository.save(topic);
        //.save will do update if the row is already existing.
    }

    public void deleteTopic(String id)
    {
//topics.removeIf(t-> t.getId().equals(id));
        topicsRepository.deleteById(id);
    }

}
