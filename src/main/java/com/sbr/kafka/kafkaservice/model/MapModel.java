package com.sbr.kafka.kafkaservice.model;

import java.util.Map;

public interface MapModel {
    Object fromMap(Object mapObj);

    Map<String, Object> toMap();
}