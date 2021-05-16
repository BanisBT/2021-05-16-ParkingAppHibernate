package org.tomasbarauskas.entities.parking.record;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_fine")
public class ParkingFine extends ParkingRecord{

    @Column(name = "fine_date_time")
    private LocalDateTime fineDateTime = LocalDateTime.now();

    @Column(name = "amount_fine")
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
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