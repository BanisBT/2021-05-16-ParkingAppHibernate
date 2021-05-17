package org.tomasbarauskas.entities.parking.record;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import org.tomasbarauskas.entities.parking.ParkingCityName;
import org.tomasbarauskas.entities.parking.zone.ParkingZone;
import org.tomasbarauskas.entities.user.User;

import javax.persistence.*;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class ParkingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usertable_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "parking_zone_id")
    private ParkingZone parkingZone;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_city")
    private ParkingCityName cityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_status")
    @Builder.Default
    private ParkingRecordStatus recordStatus = ParkingRecordStatus.UNPAID;

    @Tolerate
    public ParkingRecord() {
    }
}