package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		super("Dealer");
		deck = new Deck();
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public void shuffleDeck() {
		deck.shuffle();
	}

	public Deck getDeck() {
		return deck;
	}

	public void displayPartialHand() {
		System.out.println(getName() + "'s hand:");
		List<Card> cards = getHand().getCards();
		if (cards.isEmpty()) {
			System.out.println("[Hidden Card]");
		} else {
			System.out.println("[Hidden Card]");
			for (int i = 1; i < cards.size(); i++) {
				System.out.println(cards.get(i));
			}
		}
	}
}
