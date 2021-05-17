package org.tomasbarauskas.entities.parking.zone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "parking_zone")
@Builder
@Setter
@Getter
@ToString
public class ParkingZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "zone_name")
    private ParkingZoneName zoneName;

    @Column(name = "cost_per_hour")
    private BigDecimal pricePerHour = new BigDecimal(BigInteger.ZERO);

    @Column(name = "fine")
    private BigDecimal fine = new BigDecimal(BigInteger.ZERO);

    @Tolerate
    public ParkingZone() {
    }
}