package com.example.demo.web;

import com.example.demo.domain.entity.Location;
import com.example.demo.domain.entity.LocationDoc;
import com.example.demo.dto.LocationDTO;
import com.example.demo.service.LocationDocService;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/locations")
@RequiredArgsConstructor
public class LocationMOController {

    private final LocationDocService locationService;

    @GetMapping("")
    List<LocationDoc> locations(){
        return locationService.fetchLocations();
    }

    @GetMapping("/{id}")
    Optional<LocationDoc> locationById(@PathVariable Long id){
        return locationService.fetchLocationById(id);
    }

    @PostMapping("")
    LocationDoc createLocation(@RequestBody LocationDTO location){
        return locationService.createLocation(location);
    }

    @PutMapping("")
    LocationDoc updateLocation(@RequestBody LocationDoc LocationDoc){
        return locationService.updateLocation(LocationDoc);
    }

    @DeleteMapping("/{id}")
    void deleteLocation(@PathVariable Long id){
        locationService.deleteById(id);
    }
}
