package org.tomasbarauskas.entities.parking.record;

import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.user.User;

public abstract class ParkingRecord {
    private Long id;
    private User user;
    private ParkingZone parkingZone;
    private ParkingRecordStatus recordStatus = ParkingRecordStatus.UNPAID;

    public ParkingRecord() {
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