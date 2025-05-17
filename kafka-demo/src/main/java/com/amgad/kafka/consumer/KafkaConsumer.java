package com.amgad.kafka.consumer;

import com.amgad.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "firstTopic",groupId = "myGroup")
    public void ConsumeMsg(String message)
    {
        log.info(format("Consuming the message from firstTopic Topic:: %s", message));
    }

    @KafkaListener(topics = "firstTopic",groupId = "myGroup")
    public void ConsumeMsg(Student student)
    {
        log.info(format("Consuming the message from firstTopic Topic:: %s", student.toString()));
    }
}
