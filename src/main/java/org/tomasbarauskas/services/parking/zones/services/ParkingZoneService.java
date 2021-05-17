package org.tomasbarauskas.services.parking.zones.services;

import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.parking.zone.ParkingZoneName;

public interface ParkingZoneService {

    void saveOrUpdate(ParkingZone zone);

    ParkingZone getZoneByName(ParkingZoneName zoneName);

    void deleteZone(ParkingZone zone);
}