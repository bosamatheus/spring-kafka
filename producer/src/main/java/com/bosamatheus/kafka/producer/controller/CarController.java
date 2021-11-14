package com.bosamatheus.kafka.producer.controller;

import java.util.UUID;

import com.bosamatheus.kafka.producer.dto.CarDTO;
import com.bosamatheus.kafka.producer.service.CarProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarProducerService service;

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody final CarDTO carDTO) {
        final CarDTO car = new CarDTO(UUID.randomUUID().toString(), carDTO.model(), carDTO.color());
        service.send(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }
}
