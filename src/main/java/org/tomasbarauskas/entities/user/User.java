package org.tomasbarauskas.entities.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import org.tomasbarauskas.entities.parking.record.ParkingTicket;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usertable")
@Builder
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "car_number")
    private String carNumber = "Temp";

    @Column(name = "user_balance")
    private BigDecimal balance = new BigDecimal(BigInteger.ZERO);

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole role = UserRole.REGULAR;

    @OneToMany(mappedBy = "user")
    private List<ParkingTicket> tickets;

    @Tolerate
    public User() {
    }
}