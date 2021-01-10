package com.md.homework.domain.applyHouse;

import com.md.homework.domain.Answer;
import com.md.homework.domain.customer.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class ApplyHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(nullable = false)
    private String applicant;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String starting_point;

    private int starting_point_floor;

    @Column(nullable = false)
    private String destination;

    private int destination_floor;

    @Column(nullable = false)
    private LocalDateTime moving_at;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_storage_option;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_term_agree;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_personal_submit_agree;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Answer is_marketing_receive_agree;

    @Builder
    public ApplyHouse(Customer customer, String applicant, String contact, String starting_point, int starting_point_floor, String destination, int destination_floor, LocalDateTime moving_at, Answer is_storage_option, Answer is_term_agree, Answer is_personal_submit_agree, Answer is_marketing_receive_agree) {
        this.customer = customer;
        this.applicant = applicant;
        this.contact = contact;
        this.starting_point = starting_point;
        this.starting_point_floor = starting_point_floor;
        this.destination = destination;
        this.destination_floor = destination_floor;
        this.moving_at = moving_at;
        this.is_storage_option = is_storage_option;
        this.is_term_agree = is_term_agree;
        this.is_personal_submit_agree = is_personal_submit_agree;
        this.is_marketing_receive_agree = is_marketing_receive_agree;
    }
}
