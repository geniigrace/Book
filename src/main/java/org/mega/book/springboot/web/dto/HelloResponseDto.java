package org.mega.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    //RequiredArgsConstructor final 이랑 notnull 이면 객체 만들어줌

    private final int amount;

}
