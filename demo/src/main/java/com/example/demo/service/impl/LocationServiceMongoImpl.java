package com.example.demo.service.impl;

import com.example.demo.domain.entity.Location;
import com.example.demo.domain.entity.LocationDoc;
import com.example.demo.dto.LocationDTO;
import com.example.demo.repository.LocationDocRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationDocService;
import com.example.demo.service.LocationService;
import com.example.demo.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServiceMongoImpl implements LocationDocService {
    private final LocationDocRepository locationDocRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public LocationDoc createLocation(LocationDTO locationDTO) {
        LocationDoc location = new LocationDoc();
        location.setId(sequenceGeneratorService.generateSequence(LocationDoc.SEQUENCE_NAME));
        location.setMetro(locationDTO.isMetro());
        location.setName(locationDTO.getName());

        return locationDocRepository.save(location);
    }

    @Override
    public List<LocationDoc> fetchLocations() {
        return locationDocRepository.findAll();
    }

    @Override
    public Optional<LocationDoc> fetchLocationById(Long id) {
        return locationDocRepository.findById(id);
    }

    @Override
    public LocationDoc updateLocation(LocationDoc location) {
        return locationDocRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
        locationDocRepository.deleteById(id);
    }


}
