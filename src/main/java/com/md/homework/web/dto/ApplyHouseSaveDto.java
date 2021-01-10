package com.md.homework.web.dto;

import com.md.homework.domain.Answer;
import com.md.homework.domain.applyHouse.ApplyHouse;
import com.md.homework.domain.customer.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApplyHouseSaveDto {

    private int customer_id;

    private String applicant;

    private String contact;

    private String starting_point;

    private int starting_point_floor;

    private String destination;

    private int destination_floor;

    private LocalDateTime moving_at;

    private Answer is_storage_option;

    private Answer is_term_agree;

    private Answer is_personal_submit_agree;

    private Answer is_marketing_receive_agree;

    @Builder
    public ApplyHouseSaveDto(int customer_id, String applicant, String contact, String starting_point, int starting_point_floor, String destination, int destination_floor, LocalDateTime moving_at, Answer is_storage_option, Answer is_term_agree, Answer is_personal_submit_agree, Answer is_marketing_receive_agree) {
        this.customer_id = customer_id;
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

    public ApplyHouse toEntity(Customer customer){
        return ApplyHouse.builder()
                .customer(customer)
                .applicant(applicant)
                .contact(contact)
                .starting_point(starting_point)
                .starting_point_floor(starting_point_floor)
                .destination(destination)
                .destination_floor(destination_floor)
                .moving_at(moving_at)
                .is_storage_option(is_storage_option)
                .is_term_agree(is_term_agree)
                .is_personal_submit_agree(is_personal_submit_agree)
                .is_marketing_receive_agree(is_marketing_receive_agree).build();
    }


}
