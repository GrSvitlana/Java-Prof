package com.telran.homework.stream_api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;
    private String colour;
    private boolean isHungry;
}
