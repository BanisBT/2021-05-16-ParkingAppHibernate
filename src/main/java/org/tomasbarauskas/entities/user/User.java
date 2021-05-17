package org.tomasbarauskas.entities.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.tomasbarauskas.entities.parking.record.ParkingTicket;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usertable")
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
    private String carNumber;

    @Column(name = "user_balance")
    private BigDecimal balance;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole role = UserRole.REGULAR;

    @OneToMany(mappedBy = "user")
    private List<ParkingTicket> tickets;

    public User() {
    }

    public User(String userId, String password, String name, String surname, String carNumber) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.carNumber = carNumber;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public void setCarNumber(String carNumber) {
//        this.carNumber = carNumber;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public void setRole(UserRole role) {
//        this.role = role;
//    }

}