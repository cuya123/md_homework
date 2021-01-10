package com.md.homework.domain.moveCompany;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VehicleType{

    ONE_POINT_FIVE("1.5톤"),
    TWO_POINT_FIVE("2.5톤"),
    ETC("기타");

    private final String value;

}
