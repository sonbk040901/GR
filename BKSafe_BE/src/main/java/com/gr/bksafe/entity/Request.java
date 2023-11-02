package com.gr.bksafe.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;
import java.util.List;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 01/11/2023
 * @Time: 09:05
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class Request extends BaseEntity {
    @OneToMany(mappedBy = "request")
    private List<Location> locations;
    private Long price;
    private Short rating;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private Date startTime;
    private Date endTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", updatable = false, insertable = false)
    @ToString.Exclude
    private User user;
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private Integer userId;


    public Location getPickupLocation() {
        return locations.stream()
                .filter(location -> location.getType() == Location.LocationType.PICKUP)
                .findFirst().orElse(null);
    }

    public Location getDropOffLocation() {
        return locations.stream().filter(location -> location.getType() == Location.LocationType.DROP_OFF)
                .findFirst().orElse(null);
    }

    public List<Location> getStopLocation() {
        return locations.stream().filter(location -> location.getType() == Location.LocationType.STOP)
                .toList();
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PENDING(0, "pending"),
        ACCEPTED(1, "accepted"),
        REJECTED(2, "rejected"),
        CANCELLED(3, "cancelled"),
        DRIVING(4, "driving"),
        COMPLETED(5, "completed");
        private final Integer value;
        private final String name;
    }
}
