package hw3test1;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import base.ItemView;

public class ItemRenderer extends JPanel implements ListCellRenderer<ItemView> {

	public ItemRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends ItemView> list, ItemView view, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub

		if (isSelected) {
			view.setBackground(list.getSelectionBackground());
			view.setForeground(list.getSelectionForeground());
			this.setBackground(Color.BLUE);
			this.setForeground(Color.BLUE);
		} else {
			view.setBackground(list.getBackground());
			view.setForeground(list.getForeground());
		}

		return view;
	}

}