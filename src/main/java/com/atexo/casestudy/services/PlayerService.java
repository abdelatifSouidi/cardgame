package com.atexo.casestudy.services;

import com.atexo.casestudy.Card;
import com.atexo.casestudy.Deck;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("playerService")
public class PlayerService {
    private Deck deck = new Deck();
    private ArrayList<Card> hand = new ArrayList<>();


    public ArrayList<Card> drawHand() {
        deck.init();
        for (int i = 0; i < 10; i++) {
            Card card = deck.pull();
            deck.getCards().removeIf(c -> c.equals(card));
            hand.add(card);
        }
        return hand;
    }

    public List<Card> sortedHand() {
        List<String> definedRankOrder = deck.getRanks();
        Comparator<Card> compareBySuitsAndRank = Comparator
                .comparing(Card::getSuit)
                .thenComparing(c -> definedRankOrder.indexOf(c.getRank()));

        List<Card> sortedCards = hand.stream()
                .sorted(compareBySuitsAndRank)
                .collect(Collectors.toList());
        return sortedCards;
    }

    public Deck getDeck() {
        return deck;
    }
}
