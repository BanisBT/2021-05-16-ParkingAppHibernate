package org.tomasbarauskas.services.parking.records.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.record.ParkingFine;
import org.tomasbarauskas.utilities.HibernateConfiguration;

import java.util.List;

public class ParkingFineServiceImpl implements ParkingFineService {

    @Override
    public void saveOrUpdate(ParkingFine fine) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(fine);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public ParkingFine getParkingFineById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        ParkingFine fine = null;

        try {
            fine = session.get(ParkingFine.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return fine;
    }

    @Override
    public List<ParkingFine> getFinesByParkingCity(ParkingCityName cityName) {
        return null;
    }

    @Override
    public void deleteParkingFine(ParkingFine fine) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(fine);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
