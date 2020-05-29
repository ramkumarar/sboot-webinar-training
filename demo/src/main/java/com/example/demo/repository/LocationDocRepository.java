package com.example.demo.repository;

import com.example.demo.domain.entity.LocationDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationDocRepository extends MongoRepository<LocationDoc,Long> {
}
