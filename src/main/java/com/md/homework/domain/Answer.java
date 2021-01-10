package com.md.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Answer{

    Y( "예"),
    N( "아니오");

    private final String title;

}
