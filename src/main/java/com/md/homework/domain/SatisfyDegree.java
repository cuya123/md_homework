package com.md.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SatisfyDegree {

    VERY_LOW(-2),
    LOW(-1),
    NORMAL(0),
    GOOD(1),
    VERY_GOOD(2);

    private final int value;
}
