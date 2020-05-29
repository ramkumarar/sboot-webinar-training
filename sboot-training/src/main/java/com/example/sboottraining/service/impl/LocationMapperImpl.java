package com.example.sboottraining.service.impl;

import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;
import com.example.sboottraining.service.LocationMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationMapperImpl implements LocationMapper {
    @Override
    public Location map(LocationDTO locationDTO) {
        return new Location (locationDTO.getId(),locationDTO.getName(),locationDTO.isMetro());
    }

    @Override
    public LocationDTO map(Location location) {
        return new LocationDTO (location.getId(),location.getName(),location.isMetro());
    }
}
