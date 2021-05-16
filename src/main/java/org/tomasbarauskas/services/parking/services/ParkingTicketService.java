package org.tomasbarauskas.services.parking.services;

import org.tomasbarauskas.entities.parking.record.ParkingTicket;

public interface ParkingTicketService {
    ParkingTicket getTicketById(Long id);

    void saveOrUpdate(ParkingTicket ticket);
}