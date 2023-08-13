package com.sbr.kafka.kafkaservice.service.services;

import com.sbr.kafka.kafkaservice.model.Request;
import reactor.core.publisher.Flux;

public interface ConsumerService<T> {
    Flux<Request> consume();
}
