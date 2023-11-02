package com.gr.bksafe.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 01/11/2023
 * @Time: 09:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {
    private String address;
    //kinh độ
    private Double longitude;
    //vĩ độ
    private Double latitude;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", columnDefinition = "tinyint")
    private LocationType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "request_id")
    private Request request;

    public enum LocationType {
        //Điểm đón tài xế
        PICKUP,
        //Điểm dừng
        STOP,
        //Điểm trả khách
        DROP_OFF
    }
}
