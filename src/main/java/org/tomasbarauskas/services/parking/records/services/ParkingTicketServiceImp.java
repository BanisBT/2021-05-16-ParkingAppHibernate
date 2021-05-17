package org.tomasbarauskas.services.parking.records.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tomasbarauskas.entities.parking.record.ParkingTicket;
import org.tomasbarauskas.services.parking.records.services.ParkingTicketService;
import org.tomasbarauskas.utilities.HibernateConfiguration;

public class ParkingTicketServiceImp implements ParkingTicketService {

    @Override
    public ParkingTicket getTicketById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        ParkingTicket ticket = null;

        try {
            ticket = session.get(ParkingTicket.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return ticket;
    }

    @Override
    public void saveOrUpdate(ParkingTicket ticket) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(ticket);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}