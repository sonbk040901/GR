package com.gr.bksafe.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "1")
public class Driver extends User {
    private Date birthday;
    private String address;
    private Float rating;
}
