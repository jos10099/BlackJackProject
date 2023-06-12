package com.skilldistillery.blackjack.entities;

public class Player {
	private String name;
	private Hand hand;

	public Player(String name) {
		this.name = name;
		hand = new BlackjackHand();
	}

	public String getName() {
		return name;
	}

	public Hand getHand() {
		return hand;
	}

	public void displayHand() {
		hand.display();
	}
}