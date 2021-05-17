package org.tomasbarauskas.services.parking.records.services;

import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.record.ParkingFine;

import java.util.List;

public interface ParkingFineService {
    void saveOrUpdate(ParkingFine fine);

    ParkingFine getParkingFineById(Long id);

    List<ParkingFine> getFinesByParkingCity(ParkingCityName cityName);

    void deleteParkingFine(ParkingFine fine);
}