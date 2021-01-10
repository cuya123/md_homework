package com.md.homework.domain.moveCompany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="move_company_id")
    private MoveCompany moveCompany;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicle_type;

    @Column(nullable = false)
    private int count;

    public void updateCount(int count){
        this.count = count;
    }

    @Builder
    public Vehicle(MoveCompany moveCompany, VehicleType vehicle_type, int count) {
        this.moveCompany = moveCompany;
        this.vehicle_type = vehicle_type;
        this.count = count;
    }
}
