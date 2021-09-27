package com.atexo.casestudy;

import java.security.SecureRandom;
import java.util.*;

public class Deck {
    private ArrayList<Card> cards;
    private final List<String> ranks =  Arrays.asList("Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King");
    private static final SecureRandom random = new SecureRandom();


    public Deck() {
        createDeck();
    }

    public Card pull() {
        Card card = createRandomCard();
        while(!cards.contains(card)) {
            card = createRandomCard();
        }
        return card;
    }

    private Card createRandomCard() {
        String suit = randomEnum(Suits.class).title;
        String rank = ranks.get(random.nextInt(ranks.size()) );

        return new Card(suit, rank);
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    private void createDeck() {
        cards = new ArrayList<>();
        for (String rank: ranks) {
            cards.add(new Card(Suits.CLUB.title,rank));
            cards.add(new Card(Suits.DIAMOND.title,rank));
            cards.add(new Card(Suits.HEART.title, rank));
            cards.add(new Card(Suits.SPADE.title,rank));
        }
    }

    public void init() {
        createDeck();
        Collections.shuffle(cards);
    }

    public List<String> getRanks() {
        return ranks;
    }
}
