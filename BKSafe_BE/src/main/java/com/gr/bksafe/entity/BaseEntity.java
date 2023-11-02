package com.gr.bksafe.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 27/10/2023
 * @Time: 02:16
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date updatedAt;
}
