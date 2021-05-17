package org.tomasbarauskas.entities.parking.record;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import org.tomasbarauskas.entities.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_ticket")
@Builder
@Getter
@Setter
@ToString
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

    @Tolerate
    public ParkingTicket() {
    }
}