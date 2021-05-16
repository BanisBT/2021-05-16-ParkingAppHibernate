package org.tomasbarauskas.entities.parking.record;

import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.user.User;

import javax.persistence.*;

@MappedSuperclass
public abstract class ParkingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_zone_id")
    private ParkingZone parkingZone;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_city")
    private ParkingCityName cityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_status")
    private ParkingRecordStatus recordStatus = ParkingRecordStatus.UNPAID;

    public ParkingRecord() {
    }

    public ParkingCityName getCityName() {
        return cityName;
    }

    public void setCityName(ParkingCityName cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingZone getParkingZone() {
        return parkingZone;
    }

    public void setParkingZone(ParkingZone parkingZone) {
        this.parkingZone = parkingZone;
    }

    public ParkingRecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(ParkingRecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "ParkingRecord{" +
                "id=" + id +
                ", user=" + user +
                ", parkingZone=" + parkingZone +
                ", recordStatus=" + recordStatus +
                '}';
    }
}