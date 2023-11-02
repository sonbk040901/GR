package com.gr.bksafe.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 28/10/2023
 * @Time: 15:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlateNumber;
    private String vin;
    private String transmission;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false)
    @ToString.Exclude
    private User owner;
    @Column(name = "owner_id", updatable = false)
    @CreatedBy
    private Integer ownerId;
}
