package base;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A dialog for tracking the price of an item.
 *
 * @author Yoonsik Cheon
 */
@SuppressWarnings("serial")
public class Main extends JFrame {

	/** Default dimension of the dialog. */
	private final static Dimension DEFAULT_SIZE = new Dimension(700, 350);

	/** Special panel to display the watched item. */
	private ItemView itemView;

	/** Message bar to display various messages. */
	private JLabel msgBar = new JLabel(" ");

	/** Create a new dialog. */
	public Main() {
		this(DEFAULT_SIZE);
	}

	/** Create a new dialog of the given screen dimension. */
	public Main(Dimension dim) {
		super("Price Watcher");
		setSize(dim);

		configureUI();
		// setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		// setResizable(false);
		showMessage("Welcome!");
	}

	/**
	 * Callback to be invoked when the refresh button is clicked. Find the current
	 * price of the watched item and display it along with a percentage price
	 * change.
	 */
	private void refreshButtonClicked(ActionEvent event) {
		// --
		// -- WRITE YOUR CODE HERE!
		// --
		this.itemView.getItem().updatePrice();
		showMessage("Current Price: $" + this.itemView.getItem().getPrice());
		repaint();
	}

	/**
	 * Callback to be invoked when the view-page icon is clicked. Launch a (default)
	 * web browser by supplying the URL of the item.
	 */
	private void viewPageClicked() {
		// --
		// -- WRITE YOUR CODE HERE!
		// --
		this.itemView.getItem().launchBrowser();
		showMessage("Redirecting you to page now...");
	}

	/** Configure UI. */
	private void configureUI() {
		setLayout(new BorderLayout());
		JPanel control = makeControlPanel();
		control.setBorder(BorderFactory.createEmptyBorder(10, 16, 0, 16));
		add(control, BorderLayout.NORTH);
		JPanel board = new JPanel();
		board.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 16, 0, 16),
				BorderFactory.createLineBorder(Color.GRAY)));
		board.setLayout(new GridLayout(1, 1));
		itemView = new ItemView();
		itemView.setClickListener(this::viewPageClicked);
		board.add(itemView);
		add(board, BorderLayout.CENTER);
		msgBar.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 0));
		add(msgBar, BorderLayout.SOUTH);
	}

	/** Create a control panel consisting of a refresh button. */
	private JPanel makeControlPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setFocusPainted(false);
		refreshButton.addActionListener(this::refreshButtonClicked);
		panel.add(refreshButton);
		return panel;
	}

	/** Show briefly the given string in the message bar. */
	private void showMessage(String msg) {
		msgBar.setText(msg);
		new Thread(() -> {
			try {
				Thread.sleep(3 * 1000); // 3 seconds
			} catch (InterruptedException e) {
			}
			if (msg.equals(msgBar.getText())) {
				SwingUtilities.invokeLater(() -> msgBar.setText(" "));
			}
		}).start();
	}

	public static void main(String[] args) {
		new Main();
	}

}
