package org.tomasbarauskas.services.parking.records.services;

import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.record.ParkingTicket;

import java.util.List;

public interface ParkingTicketService {
    ParkingTicket getTicketById(Long id);

    void saveOrUpdate(ParkingTicket ticket);

    List<ParkingTicket> getTicketsByParkingCityName(ParkingCityName cityName);

    void deleteParkingTicket(ParkingTicket ticket);
}