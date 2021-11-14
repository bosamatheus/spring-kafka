package com.bosamatheus.kafka.consumer.service;

import com.bosamatheus.kafka.consumer.dto.CarDTO;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(CarConsumerService.class);

    @Value("${topic.name}")
    private String topic;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, CarDTO> record) {
        logger.info("Received message in topic {} (partition {}): {}", topic, record.partition(), record.value());
    }
}
