package org.tomasbarauskas.entities.parking.record;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class ParkingFine {
    private LocalDateTime fineDateTime = LocalDateTime.now();
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ParkingFine() {
    }

    public LocalDateTime getFineDateTime() {
        return fineDateTime;
    }

    public void setFineDateTime(LocalDateTime fineDateTime) {
        this.fineDateTime = fineDateTime;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ParkingFine{" +
                "fineDateTime=" + fineDateTime +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}