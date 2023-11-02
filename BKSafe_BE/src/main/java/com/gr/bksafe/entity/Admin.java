package com.gr.bksafe.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "2")
public class Admin extends User {
}
