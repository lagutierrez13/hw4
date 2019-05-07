package priceWatcher;

import java.util.*;

public class ConsoleUI {
	private Item item = new Item();

	public ConsoleUI(Item item) {
		this.item = item;
	}

	public void showWelcome() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Price Watcher!");
	}

	public void showItem() {
		// TODO Auto-generated method stub
		System.out.println("\nName:\t" + this.item.getName());
		System.out.println("URL:\t" + this.item.getUrl());
		System.out.println("Price:\t$" + this.item.getPrice());
		System.out.println("Change:\t" + this.item.getChange() + "%");
		System.out.println("Date Added:\t" + this.item.getDateAdded());
		System.out.println("Original Price:\t$" + this.item.getInitPrice());

	}

	public void showOptions() {
		System.out.println("Enter 1 (to check price), 2 (to view page), or -1 (to quit)");
	}

	public int promptUser() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int request = -1;

		try {
			request = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input. Please try again");
			input.next();
			request = input.nextInt();
		}

		return request;
	}

	public void showQuitMessage() {
		System.out.println("Thank you for using Price Watcher!");
	}

}
