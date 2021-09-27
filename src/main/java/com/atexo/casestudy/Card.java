package com.atexo.casestudy;

import java.util.Objects;

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getSuit(), card.getSuit()) && Objects.equals(getRank(), card.getRank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getRank());
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
