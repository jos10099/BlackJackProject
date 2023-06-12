package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	public int getHandValue() {
		int valueOfCards = 0;

		for (Card card : cards) {
			valueOfCards += card.getValue();
		}

		return valueOfCards;
	}

	public boolean isBlackjack() {
		return (cards.size() == 2 && getHandValue() == 21);
	}

	public boolean isBust() {
		return (getHandValue() > 21);
	}
}