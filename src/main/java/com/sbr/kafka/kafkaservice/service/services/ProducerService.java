package com.sbr.kafka.kafkaservice.service.services;

import reactor.core.publisher.Flux;

public interface ProducerService<T> {

    void sendMessage(Flux<T> request);
}
