package com.example.demo.web;

import com.example.demo.dto.LocationDTO;
import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class StubLocationController {
    private List<LocationDTO> locations = new ArrayList<LocationDTO>();

    public StubLocationController(){
        locations.addAll(ImmutableList.of (
                new LocationDTO("1","Chennai",true),
                new LocationDTO("2","Delhi",true),
                new LocationDTO("3","Mumbai",true),
                new LocationDTO("4","Chennai",true)
        ));
    }

    @GetMapping("")
    List<LocationDTO> locations(){
        return locations;
    }

    @GetMapping("/{id}")
    Optional<LocationDTO> locationById(@PathVariable String id){
        for(LocationDTO location : locations ){
            if(location.getId().equals(id)){
                return Optional.of(location);
            }
        }
        return Optional.empty();
    }

    @PostMapping("")
    LocationDTO createLocation(@RequestBody LocationDTO location){
        locations.add(location);
        return location;
    }

    @PutMapping("")
    LocationDTO updateLocation(@RequestBody LocationDTO location){
        int locationIndex = -1;

        for(LocationDTO l : locations ){
            if(l.getId().equals(location.getId())){
              locationIndex = locations.indexOf(l);
              locations.set(locationIndex,location);
            }
        }
        return (locationIndex == -1) ? createLocation(location) : location;
    }

    @DeleteMapping("/{id}")
    void deleteLocation(@PathVariable String id){
        locations.removeIf(location -> location.getId().equals(id));
    }
}
