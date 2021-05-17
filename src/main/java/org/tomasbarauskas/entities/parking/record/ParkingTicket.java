package org.tomasbarauskas.entities.parking.record;

import org.tomasbarauskas.entities.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_ticket")
public class ParkingTicket extends ParkingRecord{

    @Column(name = "began_parking")
    private LocalDateTime beganParking = LocalDateTime.now();

    @Column(name = "end_parking")
    private LocalDateTime endParking = LocalDateTime.now().plusHours(2);

    @Column(name = "amount_ticket")
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    public ParkingTicket() {
    }

    public ParkingTicket(User user) {
        super(user);
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