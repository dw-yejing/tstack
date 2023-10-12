package edu.bjtu.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ConsumerController {
    private static List<String> messages = new ArrayList<>();

    @KafkaListener(id = "webGroup", topics = "topic_input")
    public void listen(String input, Acknowledgment ack) {
        messages.add(input);
        log.info("input value: {}" , input);
        ack.acknowledge();
    }

    @KafkaListener(id = "webGroup2", topics = "topic_input")
    public void listen2(String input, Acknowledgment ack) {
        messages.add(input);
        log.info("webGroup2 revieve message: {}" , input);
        ack.acknowledge();
    }
}
