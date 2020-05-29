package com.example.demo.service;

import com.example.demo.domain.entity.Location;
import com.example.demo.dto.Employee;
import com.example.demo.dto.LocationDTO;

import java.util.List;
import java.util.Optional;


public interface LocationService {
    Location createLocation(LocationDTO locationDTO);

    List<Location> fetchLocations();

    Optional<Location> fetchLocationById(Long id);

    Location updateLocation(Location location);

    void deleteById(Long id);
}
