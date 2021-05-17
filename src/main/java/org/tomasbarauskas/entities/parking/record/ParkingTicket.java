package org.tomasbarauskas.entities.parking.record;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_ticket")
@SuperBuilder
@Getter
@Setter
@ToString
public class ParkingTicket extends ParkingRecord {

    @Column(name = "began_parking")
    @Builder.Default
    private LocalDateTime beganParking = LocalDateTime.now();

    @Column(name = "end_parking")
    @Builder.Default
    private LocalDateTime endParking = LocalDateTime.now().plusHours(2);

    @Column(name = "amount_ticket")
    @Builder.Default
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @Builder.Default
    private LocalDateTime updateAt = LocalDateTime.now();

    @Tolerate
    public ParkingTicket() {
    }
}