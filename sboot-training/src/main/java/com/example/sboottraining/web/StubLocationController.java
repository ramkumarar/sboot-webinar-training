package com.example.sboottraining.web;


import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;
import com.example.sboottraining.service.LocationMapper;
import com.example.sboottraining.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class StubLocationController {

    //@Qualifier("location-service-v1")
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @GetMapping("")
    List<LocationDTO> locations(){

        return locationService.fetchLocations().stream()
                .map(location -> locationMapper.map(location))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    Optional<LocationDTO> locationById(@PathVariable String id){
        Location location = locationService.fetchLocationById(id).get();
        return Optional.of(locationMapper.map(location));
    }

    @PostMapping("")
    LocationDTO createLocation(@RequestBody LocationDTO location){
        return locationMapper.map(locationService.createLocation(location));
    }

    @PutMapping("")
    LocationDTO updateLocation(@RequestBody LocationDTO location){
        return locationMapper.map(locationService.updateLocation(locationMapper.map(location)));
    }

    @DeleteMapping("/{id}")
    void deleteLocation(@PathVariable String id){
        locationService.deleteById(id);
    }
}
