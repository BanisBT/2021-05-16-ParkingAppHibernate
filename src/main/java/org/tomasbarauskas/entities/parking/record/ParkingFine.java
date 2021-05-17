package org.tomasbarauskas.entities.parking.record;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_fine")
@Builder
@Getter
@Setter
@ToString
public class ParkingFine extends ParkingRecord {

    @Column(name = "fine_date_time")
    private LocalDateTime fineDateTime = LocalDateTime.now();

    @Column(name = "amount_fine")
    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Tolerate
    public ParkingFine() {
    }
}