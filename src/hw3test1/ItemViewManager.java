package hw3test1;

import base.ItemView;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ItemViewManager {
	DefaultListModel<ItemView> itemViews;

	public ItemViewManager(DefaultListModel<ItemView> itemViews) {
		this.itemViews = itemViews;
	}

	public ItemViewManager() {
		this.itemViews = new DefaultListModel<ItemView>();
	}

	public void addItem(ItemView item) {
		this.itemViews.addElement(item);
	}

	public void removeItem(int index) {
		this.itemViews.removeElementAt(index);
	}

	public DefaultListModel<ItemView> getItemViews() {
		return this.itemViews;
	}
}
