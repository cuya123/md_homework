package com.md.homework.domain.moveCompany;

import com.md.homework.domain.Answer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class MoveCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ceo;

    @Column(nullable = false)
    private String company_number;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String address_detail;

    @Column(nullable = false)
    private LocalDateTime company_opened_at;

    private int employee_count;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_match_available;

    @Builder
    public MoveCompany(/*List<Vehicle> vehicles, */String name, String ceo, String company_number, String contact, String address, String address_detail, LocalDateTime company_opened_at, int employee_count, Answer is_match_available) {
//        this.vehicles = vehicles;
        this.name = name;
        this.ceo = ceo;
        this.company_number = company_number;
        this.contact = contact;
        this.address = address;
        this.address_detail = address_detail;
        this.company_opened_at = company_opened_at;
        this.employee_count = employee_count;
        this.is_match_available = is_match_available;
    }
}
