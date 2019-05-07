package base;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;

import priceWatcher.*;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel // implements ListCellRenderer<Item> {
{
	private Item item;
	// new Item("Macbook Pro", 2999.99, 2999.99,
	// "https://www.bestbuy.com/site/apple-macbook-pro-13-display-intel-core-i5-8-gb-memory-128gb-flash-storage-space-gray/5721723.p?skuId=5721723");;

	private NumberFormat df = new DecimalFormat("#0.00");

	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {

		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}

	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/image/";

	/** View-page clicking listener. */
	private ClickListener listener;

	/** Create a new instance. */
	public ItemView(Item item) {
		this.item = item;
		setPreferredSize(new Dimension(100, 160));
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
					listener.clicked();
				}
			}
		});
	}

	public ItemView() {
		setPreferredSize(new Dimension(100, 160));
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
					listener.clicked();
				}
			}
		});
	}

	/** Set the view-page click listener. */
	public void setClickListener(ClickListener listener) {
		this.listener = listener;
	}

	/** Overridden here to display the details of the item. */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Dimension dim = getSize();

		// --
		// -- WRITE YOUR CODE HERE!
		// --
		int x = 20, y = 30;
		g.drawImage(getImage("goTo.png"), x, y, 20, 20, null);
		// g.drawString("[View]", x, y);
		y += 50;
		g.drawString("Name:", x, y);
		y += 20;
		g.drawString("URL:", x, y);
		y += 20;
		g.drawString("Price:", x, y);
		y += 20;
		g.drawString("Change:", x, y);
		y += 20;
		g.drawString("Added:", x, y);

		// second section
		x += 60;
		y = 80;

		g.drawString(item.getName(), x, y);
		y += 20;
		g.drawString(item.getUrl(), x, y);
		y += 20;
		g.setColor(Color.BLUE);
		g.drawString("$" + df.format(item.getPrice()), x, y);
		y += 20;
		// change color of "change"
		if (item.getPrice() < item.getInitPrice()) {
			g.setColor(Color.GREEN);
		} else if (item.getPrice() == item.getInitPrice()) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.RED);
		}
		g.drawString(df.format(item.getChange()) + "%", x, y);
		y += 20;
		g.setColor(Color.BLACK);
		g.drawString(item.getDateAdded() + "($" + item.getInitPrice() + ")", x, y);
	}

	/** Return true if the given screen coordinate is inside the viewPage icon. */
	private boolean isViewPageClicked(int x, int y) {
		// --
		// -- WRITE YOUR CODE HERE
		// --
		return new Rectangle(25, 25, 35, 25).contains(x, y);
	}

	/** Return the image stored in the given file. */
	public Image getImage(String file) {
		try {
			URL url = new URL(getClass().getResource(IMAGE_DIR), file);
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Item getItem() {
		return this.item;
	}
}
