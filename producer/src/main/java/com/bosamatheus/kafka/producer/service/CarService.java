package com.bosamatheus.kafka.producer.service;

import com.bosamatheus.kafka.producer.dto.CarDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);
    private final String topic;
    private final KafkaTemplate<String, CarDTO> kafkaTemplate;

    public CarService(@Value("${topic.name}") String topic, KafkaTemplate<String, CarDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final CarDTO carDTO) {
        kafkaTemplate.send(topic, carDTO).addCallback(
                success -> logger.info("Message sent: {}", success.getProducerRecord().value()),
                failure -> logger.error("Unable to send message: {} due to {}", carDTO, failure.getMessage()));
    }
}
