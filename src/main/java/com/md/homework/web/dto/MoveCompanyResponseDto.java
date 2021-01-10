package com.md.homework.web.dto;

import com.md.homework.domain.Answer;
import com.md.homework.domain.moveCompany.MoveCompany;
import lombok.Getter;

@Getter
public class MoveCompanyResponseDto {

    private String name;

    private String company_number;

    private String contact;

    private String address;


    private Answer is_match_available;

    public MoveCompanyResponseDto(MoveCompany entity) {
        this.name = entity.getName();
        this.company_number = entity.getCompany_number();
        String pattern = "(\\w)(\\w)(\\w)(\\w)$";
        this.contact = entity.getContact().replaceAll(pattern, "$1**$4");
        this.address = entity.getAddress();
        this.is_match_available = entity.getIs_match_available();
    }
}
