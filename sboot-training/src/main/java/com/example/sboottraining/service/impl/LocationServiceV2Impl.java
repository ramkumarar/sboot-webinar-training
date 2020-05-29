package com.example.sboottraining.service.impl;

import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;
import com.example.sboottraining.service.LocationMapper;
import com.example.sboottraining.service.LocationService;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Qualifier("location-service-v2")
@Profile("!local")
public class LocationServiceV2Impl implements LocationService {

    private final LocationMapper locationMapper;
    private List<Location> locations = new ArrayList<>();


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

        String updatedName = String.format("%s @India", locationDTO.getName());
        LocationDTO locationDTO1 = new LocationDTO(locationDTO.getId(), updatedName, locationDTO.isMetro());
        Location location =locationMapper.map(locationDTO1);
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
