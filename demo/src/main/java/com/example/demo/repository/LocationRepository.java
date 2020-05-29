package com.example.demo.repository;

import com.example.demo.domain.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location,Long> {
    List<Location> findByName(String name);
    List<Location> findAll();
}
