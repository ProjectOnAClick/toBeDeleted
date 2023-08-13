package com.sbr.kafka.kafkaservice.repository.repositories;

import reactor.core.publisher.Flux;

public interface ConsumerRepository<T> {

    Flux<T> consumeMessage();

}
