package com.atexo.casestudy;

public enum Suits {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");



    String title;

    Suits(String title) {
        this.title = title;
    }
}
