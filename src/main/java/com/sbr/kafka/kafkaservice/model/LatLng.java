package com.sbr.kafka.kafkaservice.model;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "instance")
@NoArgsConstructor(staticName = "instance")
@Builder(builderMethodName = "location")
public class LatLng {
    @NonNull
    private String latitude;
    @NonNull
    private String longitude;
}