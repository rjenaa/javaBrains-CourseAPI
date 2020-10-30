package com.example.courseapi.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

//    List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framkework", "Description"),
//            new Topic("java", "Core Java", "Description"),
//            new Topic("javascript", "Javascript", "Description")
//    ));

    public List<Topic> getAllTopics(){
       List<Topic> topics = new ArrayList<>();
       topicRepository.findAll().forEach(topics::add);
       return topics;
    }

    public Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
     topicRepository.save(topic);
    }


    public void deleteTopic(String id, Topic topic) {
        topicRepository.delete(topic);
    }
}
