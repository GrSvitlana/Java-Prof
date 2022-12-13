package com.telran.homework.stream_api;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Cat {
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String colour;
    @NonNull
    private boolean isHungry;
    private String catOwner;
}
