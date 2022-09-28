package com.telran.homework.Sep26_deal;

import lombok.Getter;

@Getter
public enum Suit {
    CLUBS('♣'),
    DIAMONDS('♦'),
    HEARTH('♥'),
    SPADES('♠');

    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }
}
