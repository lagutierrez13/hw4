// Created by: Luis Gutierrez
// CS 3331
package priceWatcher;

import java.awt.*;
import java.io.IOException;
import java.net.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();

	}

	public void run() {

		Item item = new Item("Macbook Pro 13", 1199.99, 1199.99,
				"https://www.bestbuy.com/site/apple-macbook-pro-13-display-intel-core-i5-8-gb-memory-128gb-flash-storage-space-gray/5721723.p?skuId=5721723");

		ConsoleUI ui = new ConsoleUI(item);
		ui.showWelcome();

		/*
		 * repeat until user ask for quit, print the item, prompt the user, process
		 */
		int request = -1;
		do {
			ui.showItem();
			ui.showOptions();

			request = ui.promptUser();
			switch (request) {
			case 1: // check price (update price)
				item.updatePrice();
				break;
			case 2: // view web-page (open web-page)
				item.launchBrowser();
				break;
			}
		} while (request != -1);
		ui.showQuitMessage();
	}

}
