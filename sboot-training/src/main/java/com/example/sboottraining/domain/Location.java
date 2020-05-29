package com.example.sboottraining.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Location {
    private final String id;
    private final String name;
    private final boolean metro;
}
