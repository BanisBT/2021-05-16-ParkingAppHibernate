package org.tomasbarauskas.services.parking.services;

import org.junit.jupiter.api.*;
import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.record.ParkingTicket;
import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.parking.zone.ParkingZoneName;
import org.tomasbarauskas.entities.user.User;
import org.tomasbarauskas.services.parking.records.services.ParkingTicketService;
import org.tomasbarauskas.services.parking.records.services.ParkingTicketServiceImp;
import org.tomasbarauskas.services.parking.zones.services.ParkingZoneService;
import org.tomasbarauskas.services.parking.zones.services.ParkingZoneServiceImpl;
import org.tomasbarauskas.services.user.services.UserService;
import org.tomasbarauskas.services.user.services.UserServiceImpl;
import org.tomasbarauskas.utilities.HibernateConfiguration;

import java.math.BigDecimal;

class ParkingTicketServiceImpTest {

    private final ParkingTicketService ticketService = new ParkingTicketServiceImp();
    private final UserService userService = new UserServiceImpl();
    private final ParkingZoneService zoneService = new ParkingZoneServiceImpl();

    private final User testUser = User.builder()
            .userId("Test")
            .password("Test")
            .name("TestName")
            .surname("TestSurname")
            .build();

    private final ParkingZone testZone = ParkingZone.builder()
            .zoneName(ParkingZoneName.TEST_ZONE)
            .pricePerHour(new BigDecimal(2))
            .fine(new BigDecimal(50))
            .build();

    private final ParkingTicket testTicket = ParkingTicket.builder()
            .cityName(ParkingCityName.VILNIUS)
            .build();

    @BeforeAll
    static void beforeAll() {
        HibernateConfiguration.buildSessionFactory();
    }

    @AfterAll
    static void afterAll() {
        HibernateConfiguration.closeSessionFactory();
    }

    @BeforeEach
    void beforeEach() {
        userService.saveOrUpdate(testUser);
        zoneService.saveOrUpdate(testZone);
        testTicket.setUser(userService.getUserById(testUser.getId()));
        testTicket.setParkingZone(zoneService.getZoneByName(testZone.getZoneName()));
    }

    @AfterEach
    void afterEach() {
        zoneService.deleteZone(testZone);
        userService.deleteUser(testUser);
        ticketService.deleteParkingTicket(testTicket);
    }

    @Test
    void getTicketById() {
    }

    @Test
    void saveOrUpdate() {
        ticketService.saveOrUpdate(testTicket);

        Assertions.assertEquals(testTicket.getId(), ticketService.getTicketById(testTicket.getId()).getId());
    }
}