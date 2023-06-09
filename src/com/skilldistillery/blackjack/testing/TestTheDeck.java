package com.skilldistillery.blackjack.testing;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class TestTheDeck {

    public static void main(String[] args) {
        Deck deck = new Deck();
        
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }
    }
}
