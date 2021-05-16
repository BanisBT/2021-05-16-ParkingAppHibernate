package org.tomasbarauskas.entities.parking.zone;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ParkingZone {

    private Long id;
    private ParkingZoneName zoneName;
    private BigDecimal pricePerHour = new BigDecimal(BigInteger.ZERO);
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
}