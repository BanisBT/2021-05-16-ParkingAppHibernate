package org.tomasbarauskas.services.parking.zones.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.parking.zone.ParkingZoneName;
import org.tomasbarauskas.utilities.HibernateConfiguration;

public class ParkingZoneServiceImpl implements ParkingZoneService {

    @Override
    public void saveOrUpdate(ParkingZone zone) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(zone);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public ParkingZone getZoneByName(ParkingZoneName zoneName) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        ParkingZone parkingZone = null;

        try {
            Query query = session.createQuery("FROM ParkingZone WHERE zoneName = :zoneName", ParkingZone.class);
            query.setParameter("zoneName", zoneName);
            parkingZone = (ParkingZone) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return parkingZone;
    }

    @Override
    public void deleteZone(ParkingZone zone) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(zone);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}