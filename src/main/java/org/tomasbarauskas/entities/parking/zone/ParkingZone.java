package org.tomasbarauskas.entities.parking.zone;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "parking_zone")
public class ParkingZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated
    @Column(name = "zone_name")
    private ParkingZoneName zoneName;

    @Column(name = "cost_per_hour")
    private BigDecimal pricePerHour = new BigDecimal(BigInteger.ZERO);

    @Column(name = "fine")
    private BigDecimal fine = new BigDecimal(BigInteger.ZERO);

    public ParkingZone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingZoneName getZoneName() {
        return zoneName;
    }

    public void setZoneName(ParkingZoneName zoneName) {
        this.zoneName = zoneName;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "ParkingZone{" +
                "id=" + id +
                ", zoneName=" + zoneName +
                ", pricePerHour=" + pricePerHour +
                ", fine=" + fine +
                '}';
    }
}