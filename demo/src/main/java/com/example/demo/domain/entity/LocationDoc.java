package com.example.demo.domain.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document(collection = "locations")
@NoArgsConstructor
public class LocationDoc {

    @Transient
    public static final String SEQUENCE_NAME = "locations_sequence";

    @Id
    private Long id;
    private String name;
    private Boolean metro;

    public LocationDoc(String name, Boolean metro) {
        this.name = name;
        this.metro = metro;
    }
}
