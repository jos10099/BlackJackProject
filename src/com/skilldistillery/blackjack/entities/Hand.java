package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public abstract int getHandValue();

	public void clearHand() {
		cards.clear();
	}

	public boolean isBust() {
		return getHandValue() > 21;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void display() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
}
