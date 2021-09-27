package com.atexo.casestudy;

import com.atexo.casestudy.services.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Game {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        // loading the definitions from the given XML file
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");


        PlayerService playerService = (PlayerService) context.getBean("playerService");

        //start a new game
        List<Card> hand = playerService.drawHand();
        hand.stream().forEach((System.out::println));
        System.out.println("--------------------------");
        hand = playerService.sortedHand();
        hand.stream().forEach((System.out::println));
    }
}