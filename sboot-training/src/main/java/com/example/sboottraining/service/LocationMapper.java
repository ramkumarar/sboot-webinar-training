package com.example.sboottraining.service;

import com.example.sboottraining.domain.Location;
import com.example.sboottraining.dto.LocationDTO;

public interface LocationMapper {
    public Location map(LocationDTO locationDTO);

    public LocationDTO map(Location location);
}
