package com.sbr.kafka.kafkaservice.service;

import com.sbr.kafka.kafkaservice.model.Request;
import com.sbr.kafka.kafkaservice.repository.repositories.DownStreamRepository;
import com.sbr.kafka.kafkaservice.service.services.DownstreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service("redisDownStreamService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisDownStreamService implements DownstreamService<Request> {

    @Qualifier("redisDownstreamRepository")
    private final DownStreamRepository<Request> downStreamRepository;

    @Override
    public Flux<Request> push(Flux<Request> requests) {
        Flux<Request> req = this.downStreamRepository.push(requests);
        req.subscribe(sub -> log.info("request id {}", sub.getRequestId()));
        return req;
    }
}
