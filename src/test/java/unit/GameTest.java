package unit;

import com.atexo.casestudy.Deck;
import com.atexo.casestudy.Card;
import com.atexo.casestudy.services.PlayerService;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GameTest {
    private Deck deck;
    private PlayerService player;

    @Before
    public void init (){
        deck = new Deck();
        player = new PlayerService();
    }

    @Test
    public void shouldReturnADeckOfTenCards(){
        assertEquals(10, player.drawHand().size());
    }

    @Test
    public void shouldReturnARandomSuitsWhenPullCard() {
        assertTrue(deck.getCards().contains(player.getDeck().pull()));
    }

    @Test
    public void shouldRCheckIfDeckIsFilled(){
        Deck myDeck = new Deck();
        myDeck.init();
        assertNotEquals(myDeck.getCards(),deck.getCards());
    }

    @Test
    public void shouldEnsureThatDeckContainCardBeforeDrawingCard(){
        deck.init();
        List <Card> hand = player.drawHand();
        Set<Card> set = new HashSet<Card>(hand);
        assertTrue(set.size() == hand.size());
    }

    @Test
    public void shouldEnsureThatHandHasBeenDecreeseWhenDrawingCards(){
        deck.init();
        player.drawHand();
        assertEquals(42, player.getDeck().getCards().size());
    }

    @Test
    public void shouldReturnHandSortedBySuitsAndRank(){
        deck.init();
        List <Card> hand = player.drawHand();

        List<String> definedOrder = deck.getRanks();
        Comparator<Card> compareBySuitsAndRank = Comparator
                .comparing(Card::getSuit)
                .thenComparing(c -> definedOrder.indexOf(c.getRank()));

        List<Card> sortedCards = hand.stream()
                .sorted(compareBySuitsAndRank)
                .collect(Collectors.toList());

        List <Card> sortedHand = player.sortedHand();

        assertEquals(sortedCards,sortedHand);
    }
}
