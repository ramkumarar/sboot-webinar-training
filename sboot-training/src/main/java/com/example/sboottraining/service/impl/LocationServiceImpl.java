package com.example.sboottraining.service.impl;

import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;
import com.example.sboottraining.service.LocationMapper;
import com.example.sboottraining.service.LocationService;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Qualifier("location-service-v1")
@Profile("local")
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;
    private final List<Location> locations = ImmutableList.of (
            new Location("1","Chennai",true),
            new Location("2","Delhi",true),
            new Location("3","Mumbai",true),
            new Location("4","Chennai",true)
    );

    /*@Autowired
    public LocationServiceImpl(LocationMapper locationMapper){
        this.locationMapper = locationMapper;
        locations.addAll(ImmutableList.of (
                new Location("1","Chennai",true),
                new Location("2","Delhi",true),
                new Location("3","Mumbai",true),
                new Location("4","Chennai",true)
        ));
    }



    public LocationServiceImpl(){
        locations.addAll(ImmutableList.of (
                new Location("1","Chennai",true),
                new Location("2","Delhi",true),
                new Location("3","Mumbai",true),
                new Location("4","Chennai",true)
        ));
    }*/

    @Override
    public Location createLocation(LocationDTO locationDTO) {
        Location location =locationMapper.map(locationDTO);
        locations.add(location);
        return location;
    }

    @Override
    public List<Location> fetchLocations() {
        return locations;
    }

    @Override
    public Optional<Location> fetchLocationById(String id) {

        for(Location location : locations ){
            if(location.getId().equals(id)){
                return Optional.of(location);
            }
        }
        return Optional.empty();
    }

    @Override
    public Location updateLocation(Location location) {
        int locationIndex = -1;

        for(Location l : locations ){
            if(l.getId().equals(location.getId())){
                locationIndex = locations.indexOf(l);
                locations.set(locationIndex,location);
            }
        }
        return (locationIndex == -1) ? createLocation(locationMapper.map(location)) : location;
    }

    @Override
    public void deleteById(String id) {
        locations.removeIf(location -> location.getId().equals(id));
    }
}
