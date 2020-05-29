package com.example.demo.service;

import com.example.demo.domain.entity.Location;
import com.example.demo.domain.entity.LocationDoc;
import com.example.demo.dto.LocationDTO;

import java.util.List;
import java.util.Optional;


public interface LocationDocService {
    LocationDoc createLocation(LocationDTO locationDTO);

    List<LocationDoc> fetchLocations();

    Optional<LocationDoc> fetchLocationById(Long id);

    LocationDoc updateLocation(LocationDoc location);

    void deleteById(Long id);
}
