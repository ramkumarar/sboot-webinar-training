package com.example.sboottraining.service;

import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location createLocation(LocationDTO locationDTO);

    List<Location> fetchLocations();

    Optional<Location> fetchLocationById(String id);

    Location updateLocation(Location location);

    void deleteById(String id);
}
