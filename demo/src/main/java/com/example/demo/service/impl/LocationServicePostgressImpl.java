package com.example.demo.service.impl;

import com.example.demo.domain.entity.Location;
import com.example.demo.dto.LocationDTO;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServicePostgressImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Location createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setMetro(locationDTO.isMetro());
        location.setName(locationDTO.getName());

        return locationRepository.save(location);
    }

    @Override
    public List<Location> fetchLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> fetchLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
         locationRepository.deleteById(id);
    }


}
