package com.md.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovingType{

    HOUSE("가정이사"),
    STUDIO("원룸이사");

    private final String value;

}
