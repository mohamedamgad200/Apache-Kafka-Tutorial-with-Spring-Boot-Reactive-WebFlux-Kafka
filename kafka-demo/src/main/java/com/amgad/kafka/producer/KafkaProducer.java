package com.amgad.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    public void send(String msg)
    {
        log.info(format("Sending message to firstTopic Topic:: %s",msg));
        kafkaTemplate.send("firstTopic",msg);
    }
}
