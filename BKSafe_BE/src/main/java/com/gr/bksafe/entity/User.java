package com.gr.bksafe.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 28/10/2023
 * @Time: 14:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "tinyint default 0")
@DiscriminatorValue(value = "0")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    @Column(columnDefinition = "char(10)")
    private String phone;
    private String fullName;
    private String avatar;
    @Enumerated(EnumType.ORDINAL)
    @ColumnDefault("2")
    private Gender gender = Gender.OTHER;
    private boolean isActivated;
    @Column(insertable = false, updatable = false)
    @Enumerated(EnumType.ORDINAL)
    @ColumnDefault("0")
    private Role role = Role.USER;
    @OneToOne(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Car car;


    @Getter
    @RequiredArgsConstructor
    public enum Gender {
        MALE(0, "male"),
        FEMALE(1, "female"),
        OTHER(2, "other");
        private final int value;
        private final String name;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Role {
        USER(0, "user"),
        DRIVER(1, "driver"),
        ADMIN(2, "admin");
        private final Integer value;
        private final String name;
    }
}
