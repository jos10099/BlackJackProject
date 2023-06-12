package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BJApp {

	private Dealer dealer;
	private Player player;
	private Scanner sc;

	public static void main(String[] args) {
		BJApp bj = new BJApp();
		bj.run();
	}

	public BJApp() {
		dealer = new Dealer();
		player = new Player("Your");
		sc = new Scanner(System.in);
	}

	public void run() {
		dealer.shuffleDeck();
		System.out.println("Welcome to Blackjack!");

		while (true) {

			if (dealer.getDeck().getCards().size() < 20) {
				System.out.println("Reshuffling the deck...");
				dealer.shuffleDeck();
			}

			player.getHand().clearHand();
			dealer.getHand().clearHand();
			player.getHand().addCard(dealer.dealCard());
			dealer.getHand().addCard(dealer.dealCard());
			player.getHand().addCard(dealer.dealCard());
			dealer.getHand().addCard(dealer.dealCard());

			System.out.println();
			player.displayHand();
			System.out.println();
			dealer.displayPartialHand();

			if (player.getHand() instanceof BlackjackHand && ((BlackjackHand) player.getHand()).isBlackjack()) {
				System.out.println("\nPlayer has a blackjack! Player wins!");
			} else {

				playerTurn();

				if (!player.getHand().isBust()) {

					dealerTurn();

				}
			}

			determineWinner();

			System.out.print("\nDo you wish to play again? (Y/N): ");
			System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			String choice = sc.nextLine();

			if (!choice.equalsIgnoreCase("Y")) {
				break;
			}
		}

		System.out.println("\nThanks for playing!!");
		sc.close();
	}

	private void playerTurn() {
		while (true) {
			System.out.print("\nDo you want to Hit (H) or Stand (S)? ");
			String choice = sc.nextLine();

			if (choice.equalsIgnoreCase("H")) {
				Card card = dealer.dealCard();
				player.getHand().addCard(card);
				System.out.println("\nYou hit and receive: " + card);
				player.displayHand();
				System.out.println("Hand Value: " + player.getHand().getHandValue());

				if (player.getHand().isBust()) {
					break;
				}
			} else if (choice.equalsIgnoreCase("S")) {
				break;
			} else {
				System.out.println("Invalid choice. Please enter H or S.");
			}
		}
	}

	private void dealerTurn() {
		System.out.println("\nDealer's turn:");

		while (dealer.getHand().getHandValue() < 17) {
			Card card = dealer.dealCard();
			dealer.getHand().addCard(card);
			System.out.println("\nDealer hits and receives: " + card);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}

		dealer.displayPartialHand();
		System.out.println("Hand Value: " + dealer.getHand().getHandValue());
	}

	private void determineWinner() {
		int playerHandValue = player.getHand().getHandValue();
		int dealerHandValue = dealer.getHand().getHandValue();

		System.out.println("\nYour hand:");
		player.displayHand();
		System.out.println("Your hand value: " + playerHandValue);

		System.out.println("\nDealer's hand:");
		dealer.displayHand();
		System.out.println("Dealer's hand value: " + dealerHandValue);

		if (playerHandValue > 21) {
			System.out.println("\nYou bust! The Dealer wins.");
		} else if (dealerHandValue > 21) {
			System.out.println("\nThe Dealer busts! You win!");
		} else if (playerHandValue > dealerHandValue) {
			System.out.println("\nYou win!");
		} else if (dealerHandValue > playerHandValue) {
			System.out.println("\nThe Dealer wins!");
		} else {
			System.out.println("\nIt's a push (tie)!");
		}
	}
}
