package com.md.homework.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.md.homework.domain.applyHouse.ApplyHouse;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ApplyHouseResponseDto {

    @JsonProperty("이름")
    private String applicant;

    @JsonProperty("연락처")
    private String contact;

    @JsonProperty("출발지")
    private String starting_point;

    @JsonProperty("도착지")
    private String destination;

    @JsonProperty("이사일자")
    private LocalDate moving_at;

    @JsonProperty("보관이사여부")
    private Boolean is_storage_option;

    public ApplyHouseResponseDto(ApplyHouse entity) {
        this.applicant = entity.getApplicant();
        this.contact = entity.getContact();
        this.starting_point = entity.getStarting_point();
        this.destination = entity.getDestination();
        this.moving_at = entity.getMoving_at().toLocalDate();
        this.is_storage_option = entity.getIs_storage_option().name().equals("Y")? true : false;
    }
    /*"이름": "홍길동",
                "연락처": "010-4938-2**8",
                "출발지": "서울 송파구 방이동",
                "도착지": "경북 김천시 율곡동",
                "이사일자": "2019-02-06",
                "보관이사여부": true*/
}
