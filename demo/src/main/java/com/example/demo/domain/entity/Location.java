package com.example.demo.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // will be set when persisting

    private String name;
    private Boolean metro;

    public Location(String name, Boolean metro) {
        this.name = name;
        this.metro = metro;
    }
}
