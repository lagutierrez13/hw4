package hw4test1;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

import base.ItemView;
import hw3test1.ItemViewManager;
import priceWatcher.Item;

public class Database {
	private File file = new File("C:\\Users\\luisg\\git\\PriceWatcher\\PriceWatcher\\src\\hw4test1\\database.txt");

	public void readItems(ItemViewManager manager) {
		Scanner scnr;
		try {
			scnr = new Scanner(this.file);
			scnr.nextLine();
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] info = line.split(",");
				manager.addItem(new ItemView(new Item(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]),
						info[3], Double.parseDouble(info[4]), info[5])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void updateItem(ItemViewManager manager) throws IOException {

		try {
			PrintWriter writer = new PrintWriter(this.file);
			writer.print("");
			writer.close();

			for (int j = 0; j < manager.getItemViews().size(); j++) {
				storeItem(manager.getItemViews().getElementAt(j).getItem());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void storeItem(Item newItem) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true));// Set true for append mode

		writer.newLine(); // Add new line
		writer.write(newItem.getAll());
		writer.close();
	}
}
