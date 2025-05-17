package com.amgad.kafka.rest;

import com.amgad.kafka.payload.Student;
import com.amgad.kafka.producer.KafkaJsonProducer;
import com.amgad.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String>sendMessage(@RequestBody String message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok("Message queued successfully");
    }
    @PostMapping("/json")
    public ResponseEntity<String>sendMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
