package com.sbr.kafka.kafkaservice.controller;

import com.sbr.kafka.kafkaservice.model.Request;
import com.sbr.kafka.kafkaservice.service.services.ConsumerService;
import com.sbr.kafka.kafkaservice.service.services.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Slf4j
@Controller
public class RequestController {

    @Autowired
    private ProducerService<Request> producerService;

    @Autowired
    private ConsumerService<Request> consumerService;

    @MessageMapping("create.request.flux")
    public String requestResponse(Request request) {
        this.producerService.sendMessage(Flux.just(request));
        return "Hi from rsocket";
    }
}
