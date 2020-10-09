package com.mapsa.webstore.basicinfo.service;

import com.mapsa.webstore.basicinfo.domain.Location;

import com.mapsa.webstore.basicinfo.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> showAllLocation() {
        return locationRepository.findAll();
    }

    public Location showAllLocation(Long id) throws Exception {
        return locationRepository.findById(id).orElseThrow(() -> new Exception("not find"));
    }

    public void create(Location location) {
        Location location1 = locationRepository.findById(location.getId()).orElse(null);
        if (location1 == null) {
            locationRepository.save(location);
        }
    }

    public void patch(Location location) {
        Location location1 = locationRepository.findById(location.getId()).orElse(new Location());
        checkNull(location, location1);
        locationRepository.save(location1);
    }

    public void update(Location location) {
        locationRepository.save(location);
    }

    public void delete(Location location) {
        locationRepository.delete(location);
    }

    private Location checkNull(Location locationOne, Location locationTwo) {
        if (locationOne.getCityId() != null) {
            locationTwo.setCityId(locationOne.getCityId());
        }
        if (locationOne.getLatitude() != null) {
            locationTwo.setLatitude(locationOne.getLatitude());
        }
        if (locationOne.getTitle() != null) {
            locationTwo.setTitle(locationOne.getTitle());
        }
        if (locationOne.getRemarks() != null) {
            locationTwo.setRemarks(locationOne.getRemarks());
        }
        if (locationOne.getAddress() != null) {
            locationTwo.setAddress(locationOne.getAddress());
        }
        if (locationOne.getLockVersion() != null) {
            locationTwo.setLockVersion(locationOne.getLockVersion());
        }
        return locationTwo;
    }


}
