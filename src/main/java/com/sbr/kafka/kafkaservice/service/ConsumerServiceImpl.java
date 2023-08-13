package com.sbr.kafka.kafkaservice.service;

import com.sbr.kafka.kafkaservice.model.Request;
import com.sbr.kafka.kafkaservice.repository.repositories.ConsumerRepository;
import com.sbr.kafka.kafkaservice.service.services.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service("consumerServiceImpl")
public class ConsumerServiceImpl implements ConsumerService<Request> {

    @Autowired
    private ConsumerRepository<Request> consumerRepository;

    @Override
    public Flux<Request> consume() {
        return this.consumerRepository.consumeMessage();
    }
}
