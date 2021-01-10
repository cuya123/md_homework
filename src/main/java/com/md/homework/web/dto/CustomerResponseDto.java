package com.md.homework.web.dto;

import com.md.homework.domain.customer.Customer;
import lombok.Getter;

@Getter
public class CustomerResponseDto {

    private String name;
    private String contact;

    public CustomerResponseDto(Customer entity) {
        this.name = entity.getName();

        String pattern = "(\\w)(\\w)(\\w)(\\w)$";
        this.contact = entity.getContact().replaceAll(pattern, "$1**$4");
    }
}
