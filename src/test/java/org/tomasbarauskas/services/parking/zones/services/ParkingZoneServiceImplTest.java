package org.tomasbarauskas.services.parking.zones.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.parking.zone.ParkingZoneName;
import org.tomasbarauskas.utilities.HibernateConfiguration;

import java.math.BigDecimal;

class ParkingZoneServiceImplTest {

    private final ParkingZoneService zoneService = new ParkingZoneServiceImpl();

    private final ParkingZone testZone = ParkingZone.builder()
            .zoneName(ParkingZoneName.TEST_ZONE)
            .pricePerHour(new BigDecimal(2))
            .fine(new BigDecimal(50))
            .build();

    @BeforeAll
    static void beforeAll(){
        HibernateConfiguration.buildSessionFactory();
    }

    @AfterAll
    static void afterAll(){
        HibernateConfiguration.closeSessionFactory();
    }

    @Test
    void saveOrUpdate() {
        zoneService.saveOrUpdate(testZone);

        Assertions.assertEquals(testZone.getZoneName(), zoneService.getZoneByName(testZone.getZoneName()).getZoneName());

        zoneService.deleteZone(testZone);
    }

    @Test
    void getZoneByName() {
        zoneService.saveOrUpdate(testZone);

        Assertions.assertEquals(testZone.getZoneName(), zoneService.getZoneByName(testZone.getZoneName()).getZoneName());
        Assertions.assertNull(zoneService.getZoneByName(ParkingZoneName.NOT_IN_DB_ZONE));

        zoneService.deleteZone(testZone);
    }
}