package com.sbr.kafka.kafkaservice.processor;

import com.sbr.kafka.kafkaservice.model.Request;
import com.sbr.kafka.kafkaservice.service.services.ConsumerService;
import com.sbr.kafka.kafkaservice.service.services.DownstreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

@Slf4j
@Component
public class RedisProcess implements InitializingBean {

    @Autowired
    @Qualifier("consumerServiceImpl")
    private ConsumerService<Request> consumerService;

    @Autowired
    @Qualifier("redisDownStreamService")
    private DownstreamService<Request> redisDownstreamService;

    private Sinks.Many<Request> redisBuffer = Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("coming here");
        this.consumerService.consume().subscribe(request -> this.redisBuffer.emitNext(request, (s, e) -> true));

        this.redisDownstreamService.push(this.redisBuffer.asFlux());
    }
}
