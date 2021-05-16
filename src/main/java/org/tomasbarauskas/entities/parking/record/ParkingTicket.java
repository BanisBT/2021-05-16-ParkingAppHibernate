package org.tomasbarauskas.entities.parking.record;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class ParkingTicket extends ParkingRecord{
    private LocalDateTime beganParking = LocalDateTime.now();
    private LocalDateTime endParking = LocalDateTime.now().plusHours(2);
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ParkingTicket() {
    }

    public LocalDateTime getBeganParking() {
        return beganParking;
    }

    public void setBeganParking(LocalDateTime beganParking) {
        this.beganParking = beganParking;
    }

    public LocalDateTime getEndParking() {
        return endParking;
    }

    public void setEndParking(LocalDateTime endParking) {
        this.endParking = endParking;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "beganParking=" + beganParking +
                ", endParking=" + endParking +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                "} " + super.toString();
    }
}