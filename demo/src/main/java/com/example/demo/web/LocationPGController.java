package com.example.demo.web;

import com.example.demo.domain.entity.Location;
import com.example.demo.dto.LocationDTO;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/locations")
@RequiredArgsConstructor
public class LocationPGController {

    private final LocationService locationService;

    @GetMapping("")
    List<Location> locations(){
        List<Location> locations = locationService.fetchLocations();
        return locations;
    }

    @GetMapping("/{id}")
    Optional<Location> locationById(@PathVariable Long id){
        return locationService.fetchLocationById(id);
    }

    @PostMapping("")
    Location createLocation(@RequestBody LocationDTO location){
        return locationService.createLocation(location);
    }

    @PutMapping("")
    Location updateLocation(@RequestBody Location location){
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{id}")
    void deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
    }
}
